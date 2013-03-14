package examples;

import sun.security.util.Length;
import types.Executer;
import types.FlowData;

public class RemoveTextBetweenTriangles implements Executer{

	@Override
	public Class getOutputType() {
		return String.class;
	}

	@Override
	public String getLabel() {
		return "Remove text between characters";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		String strData = data.getData().toString();
		strData = strData.replaceAll("<br>", "/n");
		String firstPart = "";
		String secondPart = "";
		int indexEnd;
		
		for (int i = 0; i < strData.length(); i++){
			if (strData.charAt(i) == '<') {
				
				indexEnd = i;
				while (strData.charAt(indexEnd) != '>') {
					indexEnd++;
				}
				
				firstPart = strData.substring(0, i - 1);
				secondPart = strData.substring(indexEnd + 1, strData.length());
				strData = firstPart + ' ' + secondPart;
			}
		}
		FlowData fd = new FlowData(strData);
		System.out.println(fd.getData().toString());
		return fd;
	}
	

	public static void main(String[] args) {
		String b = "anat<br><br><br>anat";
		RemoveTextBetweenTriangles a = new RemoveTextBetweenTriangles();
		a.execute(new FlowData((Object)b));
	}
}
