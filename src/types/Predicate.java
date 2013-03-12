package types;
public interface Predicate extends BasicBlock{
	public Boolean execute(FlowData data);
}
