package engine;

import types.BasicCommand;

public class NodePredicate extends NodeCommand{
	
	NodeCommand trueCommand;
	NodeCommand falseCommand;
	boolean answer;
	
	public NodePredicate(BasicCommand command, Integer id) {
		super(command, id);
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
	
	public void setAnswer(boolean answer){
		this.answer=answer;
	}
	
	public boolean getAnswer(){
		return answer;
	}
	

}
