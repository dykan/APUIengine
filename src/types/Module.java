package types;

import java.util.HashMap;

import engine.GraphCommand;
import examples.PipeEnd;

public abstract class Module {
	
	HashMap<String, Class<? extends BasicCommand>> commandMap = new HashMap<>();
	
	public Module(){
		commandMap.put(GraphCommand.PIPE_END_COMMAND, PipeEnd.class);
	}
	
	public void add(BasicCommand command) {
		this.add(command.getLabel(), command.getClass());
	}
	
	public void add(String label, Class<? extends BasicCommand> commandClass) {
		commandMap.put(label, commandClass);
	}
	
	public Class<? extends BasicCommand> getCommand(String label) {
		return commandMap.get(label);
	}
}
