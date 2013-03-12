package types;

public interface Executer extends BasicBlock{
	public FlowData execute(FlowData data);
}
