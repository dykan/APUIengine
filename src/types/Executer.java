package types;

public interface Executer extends BasicCommand{
	public FlowData execute(FlowData data);
	public Class getOutputType();
}
