package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import types.Executer;
import types.FlowData;

public class ConvertFileToString implements Executer {

	public String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getLabel() {
		return "Number of words in a file";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public FlowData execute(FlowData data) {
		String everything = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return (FlowData)(Object)everything;
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
}
