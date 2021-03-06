package examples;

import types.Executer;
import types.FlowData;

public class ReturningNumber implements Executer {

	String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String getLabel() {
		return "Get the number I've entered";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(number);
	}

	@Override
	public Class getOutputType() {
		return int.class;
	}

}
