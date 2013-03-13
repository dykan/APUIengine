
package engine;

import java.util.ArrayList;

import types.BasicCommand;

public abstract class NodeCommand {
	ArrayList<NodeCommand> prevEdges;
	BasicCommand command;
	boolean executed;
	int id;
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NodeCommand(BasicCommand command, Integer id) {
		this.command = command;
		setId(id);
		setExecuted(false);
		prevEdges = new ArrayList<>();
	}

	public BasicCommand getImpl() {
		return this.command;
	}
	
	public void addPrev(NodeCommand curr){
		prevEdges.add(curr);
	}
	
	public ArrayList<NodeCommand> getPrevs()
	{
		return this.prevEdges;
	}

	public boolean getExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	

}
