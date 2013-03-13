package examples;

import java.util.ArrayList;

import types.Executer;
import types.FlowData;

public class RecordsNumFromQueryAndSaveData implements Executer{

	@Override
	public String getLabel() {
		return "Number of records of the query";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{ArrayList.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		ArrayList<Object> arrData = new ArrayList<Object>();
		arrData = (ArrayList<Object>) data.getData();
		Object numOfRows = arrData.size();
		return (FlowData)numOfRows;
	}

	@Override
	public Class getOutputType() {
		return int.class;
	}

}
