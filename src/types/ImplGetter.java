package types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import engine.GraphCommand;

import generated.Flow.Command;
import generated.Flow.Command.Attributes.Attr;

public class ImplGetter {
	
	public BasicCommand getImplByNode(Command xmlCommand){
		Class clazz = null;
		clazz = MasterModule.getClassByLabel(xmlCommand.getType());
		BasicCommand command = null;
		try {
			command = (BasicCommand)clazz.newInstance();
			doSetters(command,xmlCommand);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("error with instance of command");
			e.printStackTrace();
		}
		
		return command;
	}

	private void doSetters(BasicCommand command, Command xmlCommand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		if(xmlCommand.getAttributes() !=null){
			for (Attr curr : xmlCommand.getAttributes().getAttr()){
				// we indicate that it a predicate by an attr "contion" calculate "true"
				if (!curr.getName().equals(GraphCommand.CONDITION_ATTR)){
					// turn bla to setBla
					String first = curr.getName().substring(0, 1).toUpperCase();
					String methodName = first + curr.getName().substring(1);
					methodName = "set" +  methodName;
					Method method = 
							command.getClass().getMethod(methodName,String.class);
					method.invoke(command, curr.getValue());
				}
			}
		}
		
	}

}
