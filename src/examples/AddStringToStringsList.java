package examples;

import java.util.ArrayList;
import java.util.HashMap;

import types.Executer;
import types.FlowData;

public class AddStringToStringsList implements Executer {

	String stringToAdd;

	public String getStringToAdd() {
		return stringToAdd;
	}

	public void setStringToAdd(String stringToAdd) {
		this.stringToAdd = stringToAdd;
	}

	@Override
	public String getLabel() {
		return "Adding a string to a list of strings";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{ArrayList.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		ArrayList<String> arrStrings = new ArrayList<String>();
		arrStrings = (ArrayList<String>)(Object)data;
		arrStrings.add(stringToAdd);
		return new FlowData((Object)arrStrings);
	}

	@Override
	public Class getOutputType() {
		return HashMap.class;
	}

}
