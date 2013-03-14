package examples;

import types.Executer;
import types.FlowData;

public class GetIndex implements Executer{

	private String find;
	
	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	@Override
	public Class getOutputType() {
		return Integer.class;
	}

	@Override
	public String getLabel() {
		return "indexOf";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}
	

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(((String)data.getData()).indexOf(getFind()));
	}

}
