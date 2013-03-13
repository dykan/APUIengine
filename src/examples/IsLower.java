package examples;

import java.util.ArrayList;

import types.FlowData;
import types.Predicate;

public class IsLower implements Predicate {

	@Override
	public Boolean execute(FlowData data) {
		String strData = (String) data.getData();
		return (strData.matches("[a-z]"));
	}

	@Override
	public String getLabel() {
		return "ToLower";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

}
