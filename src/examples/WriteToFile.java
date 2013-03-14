package examples;

import java.io.BufferedWriter;
import java.io.FileWriter;

import types.Executer;
import types.FlowData;

public class WriteToFile implements Executer{

	public String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getLabel() {
		return "Writing to file";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
        try{
            FileWriter fstream = new FileWriter(fileName, true);
            BufferedWriter fbw = new BufferedWriter(fstream);
            fbw.write(data.getData().toString());
            fbw.newLine();
            fbw.close();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
		return new FlowData(data);
	}

	@Override
	public Class getOutputType() {
		return String.class;
	}

}
