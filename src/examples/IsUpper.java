package examples;

import types.FlowData;
import types.Predicate;

public class IsUpper implements Predicate {

	@Override
	public Boolean execute(FlowData data) {
		return (data.data.matches("[A-Z]"));
	}

}
