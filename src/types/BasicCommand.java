package types;


public interface BasicCommand {
	public String getLabel();
	public Class[] getInputTypes();
	public Class getOutputType();
}
