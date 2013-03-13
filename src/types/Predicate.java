package types;


public interface Predicate extends BasicCommand{
	public Boolean execute(FlowData data);
}
