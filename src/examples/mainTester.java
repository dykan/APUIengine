package examples;

import types.FlowData;
import engine.Engine;

public class mainTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String xml = "";
		Engine engine = new Engine(xml);
		FlowData data = engine.run();
		System.out.println(data.getData().toString());
	}

}
