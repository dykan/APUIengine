package examples;

import types.Executer;
import types.FlowData;

public class GetStringLength implements Executer {

	public String givenString;
	
	public String getGivenString() {
		return givenString;
	}

	public void setGivenString(String givenString) {
		this.givenString = givenString;
	}

	@Override
	public String getLabel() {
		return "Get the length of a string";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public FlowData execute(FlowData data) { 
		return (FlowData)(Object)(givenString.length());
	}

	@Override
	public Class getOutputType() {
		return int.class;
	}

}
