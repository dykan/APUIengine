package examples;

import types.Executer;
import types.FlowData;
import types.MultipleExecuter;


public class CmdOutput implements MultipleExecuter {

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
	public FlowData execute(FlowData[] data) {
		return new UniteStrings().execute(data); 
	}


}