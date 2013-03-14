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
		return null;
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(givenString);
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

}
