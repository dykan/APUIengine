package types;

import types.BasicCommand;
import types.FlowData;

public interface Predicate extends BasicCommand{
	public boolean execute(FlowData data);
}
