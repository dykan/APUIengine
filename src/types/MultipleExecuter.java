package types;

public interface MultipleExecuter extends CommandOutputer{
	public FlowData execute(FlowData[] data);
}
