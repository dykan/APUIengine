package engine;

import genrated.Flow;

import java.util.HashMap;

public class GraphCommand {
	HashMap<Integer, NodeCommand> vertices;
	
	public GraphCommand(Flow flow) {
		vertices = new HashMap<Integer, NodeCommand>();
	}
	
	public void addVertex(NodeCommand newNode) {
		vertices.put(1, newNode);
	}
	
	public void addEdge(NodeCommand srcNode, NodeCommand dstNode) {
		//srcNode.addPrev(srcNode.);
	}
}
