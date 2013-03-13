package examples;

import types.Executer;
import types.FlowData;

public class UniteFiles implements Executer {

	@Override
	public String getLabel() {
		return "Unite files";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class, String.class};
	}

	@Override
	public FlowData execute(FlowData data) {

		return null;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

}
