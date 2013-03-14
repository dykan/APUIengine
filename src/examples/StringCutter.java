package examples;

import types.FlowData;
import types.MultipleExecuter;

public class StringCutter implements MultipleExecuter{

	String direction;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

	@Override
	public String getLabel() {
		return "stringCutter";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{Integer.class, String.class};
	}

	@Override
	public FlowData execute(FlowData[] data) {
		String old;
		Integer index;
		// check if first is string or int
		if (data[0].getData() instanceof String){
			old = (String)data[0].getData();
			index = (Integer)data[1].getData();
		} else {
			old = (String)data[1].getData();
			index = (Integer)data[0].getData();
		}
		
		String newStr=null;
		if(getDirection().equals("after")){
			newStr = new String(old.substring(index.intValue()));
		} else if (getDirection().equals("before")){
			newStr = new String(old.substring(0,index.intValue()));
		} else {
			// TODO: ??
			System.out.println("do something smart");
		}
		
		return new FlowData(newStr);
	}

}
