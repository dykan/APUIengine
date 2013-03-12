package types;

public interface MultipleExecuter extends BasicBlock{
	public FlowData execute(FlowData[] data);
}
