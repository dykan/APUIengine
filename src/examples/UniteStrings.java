package examples;

import types.Executer;
import types.FlowData;
import types.MultipleExecuter;

public class UniteStrings implements MultipleExecuter{

	@Override
	public String getLabel() {
		return "Unite strings";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class, String.class};
	}

	@Override
	public FlowData execute(FlowData[] data) {
		String unitedStrings = data[0].getData().toString() + data[1].getData().toString();
		return null;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
}
