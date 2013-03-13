package types;

import java.util.HashMap;

public abstract class Module {
	
	HashMap<String, Class> commandMap = new HashMap<String, Class>();
	
	public void add(BasicCommand command){
		commandMap.put(command.getLabel(), command.getClass());
	}
	
	public Class getCommand(String label){
		return commandMap.get(label);
	}
}
