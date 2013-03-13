package examples;

import types.Module;

public class BasicModule extends Module {
	public BasicModule() {
		this.add(new CmdInput());
		this.add(new CmdOutput());
		this.add(new IsLower());
		this.add(new IsUpper());
	}
}
