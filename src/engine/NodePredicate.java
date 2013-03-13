package engine;

import types.BasicCommand;
import engine.NodeCommand;

public class NodePredicate extends NodeCommand{
	
	NodeCommand trueCommand;
	NodeCommand falseCommand;
	
	public NodePredicate(BasicCommand command) {
		super(command);
	}
	

}
