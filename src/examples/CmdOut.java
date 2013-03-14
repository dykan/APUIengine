package examples;

import types.Executer;
import types.FlowData;


public class CmdOut implements Executer{

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

	@Override
	public String getLabel() {
		return "cmdOutput";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		System.out.println(getMessage());
		return data;
	}

}
