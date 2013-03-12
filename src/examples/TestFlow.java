package examples;

import java.util.ArrayList;

import types.Executer;
import types.Flow;

public class TestFlow {

	public static void main(String[] args) {
		ArrayList<Executer> innerFlow = new ArrayList<>();
		innerFlow.add(new ToUpper());
		Flow flow = new Flow(new CmdInput(), innerFlow, new CmdOutput());
		flow.execute();
	}
}
