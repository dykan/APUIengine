package engine;


import generated.Flow;
import generated.Flow.Command;
import generated.Flow.Command.Attributes.Attr;
import generated.Flow.Command.Next;

import java.util.HashMap;

import types.BasicCommand;
import types.ImplGetter;

public class GraphCommand {
	
	HashMap<Integer, NodeCommand> vertices;
	ImplGetter getter= new ImplGetter();
	Flow flow;
	

	public static String CONDITION_ATTR = "condition";
	
	public GraphCommand(Flow flow) {
		
		this.flow = flow;
		vertices = new HashMap<Integer, NodeCommand>();
			
		addOutput();
		
		for(Command currXmlNode : flow.getCommand()){
			NodeCommand currGraphNode = addVertex(currXmlNode);
			if(currGraphNode instanceof NodePredicate){
				NodePredicate nodePredicate = (NodePredicate)currGraphNode;
				// get sons
				NodeCommand trueNode = createSonById(currXmlNode.getNext().getId().get(0));
				NodeCommand falseNode = createSonById(currXmlNode.getNext().getId().get(1));
				nodePredicate.setTrueCommand(trueNode);
				nodePredicate.setFalseCommand(falseNode);
				// set me as my sons prev
				trueNode.addPrev(currGraphNode);
				falseNode.addPrev(currGraphNode);
			} else {
				NodeExecuter nodeExecuter = (NodeExecuter)currGraphNode;
				for(Integer currId : currXmlNode.getNext().getId()){
					NodeCommand son = createSonById(currId);
					nodeExecuter.addNext(son);
					son.addPrev(currGraphNode);
				}
			}
			
			// get froms
			/*for(Integer currId : currXmlNode.getPrev().getId()){
				NodeCommand prev = createSonById(currId);
				currGraphNode.addPrev(prev);
			}*/
		}
	}

	private void addOutput() {
		Command output = new Command();
		output.setId(0);
		output.setType("output");
		Next next = new Next();
		output.setNext(next);
		flow.getCommand().add(output);
		
	}
	
	private NodeCommand createSonById(Integer id) {
		// check if already exists
		NodeCommand newNode = vertices.get(id);
		if (newNode == null){
			Command xmlNode = findNodeById(id);
			newNode = addVertex(xmlNode);
		}
		
		return newNode;
	}

	private Command findNodeById(Integer id) {
		for (Command currNode : flow.getCommand()){
			// id is equal
			if (currNode.getId().compareTo(id) == 0){
				return currNode;
			}
		}
		
		return null;
	}

	private boolean isPredicate(Command currNode) {
		// no attr at all
		if(currNode.getAttributes() == null){
			return false;
		}
		
		for (Attr attr : currNode.getAttributes().getAttr()){
			if(attr.getName().equals(CONDITION_ATTR)){
				return true;
			}
		}
		
		return false;
	}

	public NodeCommand addVertex(Command newXmlCommand) {
		// check if in already
		NodeCommand newNode = vertices.get(newXmlCommand.getId());
		if(newNode == null){
			// create the node
			BasicCommand impl = getter.getImplByNode(newXmlCommand);
			if (isPredicate(newXmlCommand)){
				newNode = new NodePredicate(impl, newXmlCommand.getId());	
			} else {
				newNode = new NodeExecuter(impl, newXmlCommand.getId());
			}
			
			vertices.put(newNode.getId(), newNode);
		}
		
		return newNode;
	}

}
