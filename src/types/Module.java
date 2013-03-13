package types;

import java.util.HashMap;

public abstract class Module {
	
	HashMap<String, BasicCommand> commandMap = new HashMap<String, BasicCommand>();
	
	public void add(BasicCommand command){
		commandMap.put(command.getLabel(), command);
	}
	
	public BasicCommand getCommand(String label){
		return commandMap.get(label);
	}
}
