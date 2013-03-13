package types;

import java.util.HashMap;

public abstract class Module {
	
	HashMap<String, Class<? extends BasicCommand>> commandMap = new HashMap<>();
	
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
