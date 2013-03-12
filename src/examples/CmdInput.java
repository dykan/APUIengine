package examples;

import java.util.Scanner;

import types.Executer;
import types.FlowData;

public class CmdInput implements Executer {

	@Override
	public String getLabel() {
		return "INPUT";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public Class getOutput() {
		return  String.class;
	}

	@Override
	public FlowData execute(FlowData data) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return new FlowData(name);
	}

}
