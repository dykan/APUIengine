package examples;

import types.Executer;
import types.FlowData;

public class StringSpliter implements Executer{

	public String Deli = " ";
	public String getDeli() {
		return Deli;
	}

	public void setDeli(String deli) {
		Deli = deli;
	}

	@Override
	public Class getOutputType() {
		return String[].class;
	}

	@Override
	public String getLabel() {
		return "StringSpliter";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(((String)data.getData()).
				split(getDeli()));
	}

}
