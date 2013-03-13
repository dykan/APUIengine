package examples;

import types.Executer;
import types.FlowData;

public class ReturningString implements Executer {

	String givenString;
	
	public String getGivenString() {
		return givenString;
	}

	public void setGivenString(String givenString) {
		this.givenString = givenString;
	}

	@Override
	public String getLabel() {
		return "Get the string I've entered";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		return (FlowData)(Object)givenString;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

}
