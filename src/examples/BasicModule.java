package examples;

import predicates.IsLower;
import predicates.IsSameString;
import predicates.IsUpper;
import types.Module;

public class BasicModule extends Module {
	public BasicModule() {
		this.add(new CmdInput());
		this.add(new CmdOutput());
		this.add(new IsLower());
		this.add(new IsUpper());
		this.add(new IsSameString());
		this.add(new ReturningNumber());
	}
}
