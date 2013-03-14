package types;

public class FlowData {
	private Object data;
	
	public FlowData(Object data) {
		this.data = data;
	}
	
	public Object getData(){
		return data;
	}
	
	public void setData(Object obj){
		data = obj;
	}
}
