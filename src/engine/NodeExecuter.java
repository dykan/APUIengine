package engine;

import java.util.ArrayList;

import types.BasicCommand;

public class NodeExecuter extends NodeCommand{
	public NodeExecuter(BasicCommand command, Integer id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	ArrayList<NodeCommand> outEdges;

	public void addNext(NodeCommand curr) {
		outEdges.add(curr);
	}
}
