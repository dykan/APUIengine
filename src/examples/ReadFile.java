package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import types.Executer;
import types.FlowData;

public class ReadFile implements Executer {

	public String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getLabel() {
		return "read file";
	}

	@Override
	public Class[] getInputTypes() {
		return null;
	}

	@Override
	public FlowData execute(FlowData data) {
		return new FlowData(GeneralUtils.convertFileToString(fileName));
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}
}
