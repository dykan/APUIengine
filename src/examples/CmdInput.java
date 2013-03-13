package examples;

import java.util.Scanner;

import types.Executer;
import types.FlowData;

public class CmdInput implements Executer {

	String message;
	
	@Override
	public String getLabel() {
		return "input";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public Class getOutputType() {
		return  String.class;
	}

	@Override
	public FlowData execute(FlowData data) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return new FlowData(name);
	}
	
	public void setMessage(String message){
		this.message=message;
	}

}
