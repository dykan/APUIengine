package types;

import java.util.ArrayList;

public interface BasicCommand {
	public String getLabel();
	public Class[] getInputTypes();
	public Class getOutputType();
}
