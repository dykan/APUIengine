package engine;

import java.util.ArrayList;

import types.BasicCommand;

public class NodeExecuter extends NodeCommand{
	public NodeExecuter(BasicCommand command, Integer id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	ArrayList<NodeCommand> outEdges = new ArrayList<NodeCommand>();

	public void addNext(NodeCommand son) {
		outEdges.add(son);
		// add me to his prevs
		son.getPrevs().add(this);
	}
}
