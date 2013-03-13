package examples;

import java.util.ArrayList;

import types.FlowData;
import types.Predicate;

public class IsUpper implements Predicate {

	@Override
	public boolean execute(FlowData data) {
		String strData= (String) data.getData();
		return (strData.matches("[A-Z]"));
	}

	@Override
	public String getLabel() {
		return "ToUpper";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

}
