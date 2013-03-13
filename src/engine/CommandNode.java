package engine;

import java.util.ArrayList;

import types.BasicCommand;

public abstract class CommandNode {
	ArrayList<CommandNode> outEdges;
	ArrayList<CommandNode> inEdges;
	BasicCommand command;
	
	public CommandNode(BasicCommand command) {
		this.command = command;
		outEdges = new ArrayList<>();
		inEdges = new ArrayList<>();
	}

	public BasicCommand getImpl() {
		return this.command;
	}
}
