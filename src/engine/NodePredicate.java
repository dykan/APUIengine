package engine;

import types.BasicCommand;
import engine.NodeCommand;

public class NodePredicate extends NodeCommand{
	
	NodeCommand trueCommand;
	NodeCommand falseCommand;
	
	public NodePredicate(BasicCommand command) {
		super(command);
	}

	public NodeCommand getTrueCommand() {
		return trueCommand;
	}

	public void setTrueCommand(NodeCommand trueCommand) {
		this.trueCommand = trueCommand;
	}

	public NodeCommand getFalseCommand() {
		return falseCommand;
	}

	public void setFalseCommand(NodeCommand falseCommand) {
		this.falseCommand = falseCommand;
	}
	

}
