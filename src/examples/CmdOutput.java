package examples;

import types.Executer;
import types.FlowData;


public class CmdOutput implements Executer {

	@Override
	public String getLabel() {
		return "OUTPUT";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public Class getOutput() {
		return String.class;
	}

	@Override
	public FlowData execute(FlowData data) {
		System.out.println(data.getData().toString());
		return data;
	}


}