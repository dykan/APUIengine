package types;

import java.util.ArrayList;

public interface BasicBlock {
	public String getLabel();
	public Class[] getInputTypes();
	public Class getOutput();
}
