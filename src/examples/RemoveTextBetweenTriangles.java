package examples;

import generated.Flow;
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
		int indexStart;
		
		for (int i = 0; i < strData.length(); i++){
			if (strData.charAt(i) == '<') {
				
				indexEnd = i;
				while ((strData.charAt(indexEnd) != '>') && (i < strData.length())) {
					indexEnd++;
				}
				
				indexStart = i;
				if (indexStart != 0) {
					indexStart --;
				}
				
				firstPart = strData.substring(0, indexStart);
				secondPart = strData.substring(indexEnd + 1, strData.length());
				strData = firstPart + ' ' + secondPart;
			}
		}
		FlowData fd = new FlowData(strData);
		System.out.println(fd.getData().toString());
		return fd;
	}
	

	public static void main(String[] args) {
		
		Template t = new Template();
		t.setTemplate("http://en.wikipedia.org/wiki/&");
		t.setWildCard("&");
		FlowData url = t.execute(new FlowData ("Nail_(anatomy)"));
		
		GetHTMLWithURL getHTML = new GetHTMLWithURL();
		FlowData htmlCodeOfURL = getHTML.execute(url);
		
		GetIndex afterIndex = new GetIndex();
		afterIndex.setFind("/table");
		FlowData indexAfterDelimiter = afterIndex.execute(htmlCodeOfURL);
		
		StringCutter stringCutterAfter = new StringCutter();
		stringCutterAfter.setDirection("after");
		FlowData htmlWithoutBeggining = 
				stringCutterAfter.execute(new FlowData[]{htmlCodeOfURL, indexAfterDelimiter});
	
		GetIndex beforeIndex = new GetIndex();
		beforeIndex.setFind("See_also");
		FlowData indexBeforeDelimiter = beforeIndex.execute(htmlWithoutBeggining);
		
		StringCutter stringCutterBefore = new StringCutter();
		stringCutterBefore.setDirection("before");
		FlowData goodHTML =
				stringCutterBefore.execute(new FlowData[]{htmlWithoutBeggining, indexBeforeDelimiter});
		
		//FlowData data = new GetHTMLWithURL().execute(new FlowData(url));
		RemoveTextBetweenTriangles a = new RemoveTextBetweenTriangles();
		FlowData awesomeHTML = a.execute(goodHTML);
		System.out.println(awesomeHTML.getData());
	}
}
