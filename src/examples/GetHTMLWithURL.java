package examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import types.Executer;
import types.FlowData;

public class GetHTMLWithURL implements Executer{

	@Override
	public String getLabel() {
		return "Get source code of an HTML code";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		String strURL = data.getData().toString();
		return new FlowData(getUrlSource(strURL));
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
	
	private static String getUrlSource(String strUrl) {
        
		StringBuilder strBuilder = null;
		try {
			URL url = new URL(strUrl);
	        URLConnection yc = url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
	        String inputLine;
	        strBuilder = new StringBuilder();
	        while ((inputLine = in.readLine()) != null)
	            strBuilder.append(inputLine);
	        in.close();
        }
        catch (IOException e){
        	e.printStackTrace();
        }
        finally {
        	
        }
        return strBuilder.toString();
    }
}
