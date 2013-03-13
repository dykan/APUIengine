package examples;

import java.util.Scanner;

import types.FlowData;
import types.Input;

public class CmdInput implements Input {

	@Override
	public FlowData Create() {
		System.out.println("input:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return new FlowData(name);
	}
}
