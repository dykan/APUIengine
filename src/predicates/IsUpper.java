package predicates;

import java.util.ArrayList;

import types.FlowData;
import types.Predicate;

public class IsUpper implements Predicate {

	@Override
	public boolean execute(FlowData data) {
		String strData = data.getData().toString();
		return (strData.matches("[A-Z]"));
	}

	@Override
	public String getLabel() {
		return "Is Upper";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

}
