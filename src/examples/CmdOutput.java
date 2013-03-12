package examples;

import types.FlowData;
import types.Output;

public class CmdOutput implements Output {

	@Override
	public void write(FlowData data) {
		System.out.println(data);
	}
}
