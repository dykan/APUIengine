package types;

import java.util.HashMap;

import examples.BasicModule;

public class MasterModule {
	private static HashMap<String, Class<? extends BasicCommand>> mapUnion = new HashMap<>();
	
	public static Class<? extends BasicCommand> getClassByLabel(String label) {
		return (mapUnion.get(label));
	}
	
	private static void addModule(Module module)
	{
		mapUnion.putAll(module.commandMap);
	}
	
	static {
		MasterModule.addModule(new BasicModule());
	}
}
