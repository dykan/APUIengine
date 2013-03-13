package examples;

import types.Executer;
import types.FlowData;


public class CmdOutput implements Executer {

	@Override
	public String getLabel() {
		return "output";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

	@Override
	public FlowData execute(FlowData data) {
		System.out.println(data.getData().toString());
		return data;
	}


}