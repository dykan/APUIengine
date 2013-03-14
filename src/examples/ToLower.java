package examples;

import types.Executer;
import types.FlowData;

public class ToLower implements Executer{

	@Override
	public String getLabel() {
		return "To lower case";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(data.getData().toString().toLowerCase());
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
	

}
