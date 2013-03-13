package types;


public interface Predicate extends BasicCommand{
	public boolean execute(FlowData data);
}
