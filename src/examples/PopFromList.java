package examples;

import java.util.ArrayList;

import types.Executer;
import types.FlowData;

public class PopFromList implements Executer{

	public int index = 0;
	@Override
	public Class getOutputType() {
		return String.class;
	}

	@Override
	public String getLabel() {
		return "PopFromList";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String[].class};
	}

	@Override
	public FlowData execute(FlowData data) {
		String[] arr = (String[])data.getData();
		
		if (arr.length == 0){
			return new FlowData("");
		}
		//get the value
		String value = new String(arr[getIndex()]);
		
		// build new string
		ArrayList<String> arrNew = new ArrayList<String>();
		for(int i=0; i<arr.length; i++){
			if(i!=getIndex()){
				arrNew.add(arr[i]);
			}
		}
		// set old data
		String[] arrSmall = new String[arr.length-1];
		data.setData(arrNew.toArray(arrSmall));
		
		return new FlowData(value);
	}
	
	public void setIndex(String str){
		this.index = Integer.parseInt(str);
	}
	
	public int getIndex(){
		return index;
	}

}
