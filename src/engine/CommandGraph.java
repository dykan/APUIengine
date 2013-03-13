package engine;

import java.util.ArrayList;

public class CommandGraph {
	ArrayList<CommandNode> vertices;
	
	public CommandGraph() {
		vertices = new ArrayList<>();
	}
	
	public void addVertex(CommandNode newNode) {
		vertices.add(newNode);
	}
	
	public void addEdge(CommandNode srcNode, CommandNode dstNode) {
		
	}
}
