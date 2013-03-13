package types;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import generated.Flow.Command;
import generated.Flow.Command.Attributes.Attr;

public class ImplGetter {
	
	public BasicCommand getImplByNode(Command xmlCommand){
		Class clazz = null;
		//MasterModule.getClassByLabel(xmlCommand.getType());
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
		for (Attr curr : xmlCommand.getAttributes().getAttr()){
			// turn bla to setBla
			String first = curr.getName().substring(0, 0).toUpperCase();
			String methodName = first + curr.getName().substring(1);
			methodName = "set" + methodName;
			Method method = 
					command.getClass().getMethod(methodName,String.class);
			method.invoke(curr.getValue());
		}
		
	}

}
