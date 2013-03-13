package examples;

import types.Executer;
import types.FlowData;

public class ToUpper implements Executer {

	@Override
	public FlowData execute(FlowData data) {
		data.data = data.data.toUpperCase();
		return data;
	}
}
