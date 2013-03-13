package examples;

import types.Module;

public class BasicModule extends Module {
	public BasicModule() {
		this.add("cmd input", CmdInput.class);
		this.add("cmd output", CmdOutput.class);
		this.add("is lower", IsLower.class);
		this.add("is upper", IsUpper.class);
	}
}
