package examples;

import types.Executer;
import types.FlowData;

public class ToUpper implements Executer{

	@Override
	public String getLabel() {
		return "To upper case";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(data.toString().toUpperCase());
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
	

}
