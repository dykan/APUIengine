package types;

import java.util.ArrayList;

public interface basicBlock {
	public String getLabel();
	public Class[] getInputTypes();
	public Class getOutput();
}
