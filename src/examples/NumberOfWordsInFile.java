package examples;

import types.Executer;
import types.FlowData;

public class NumberOfWordsInFile implements Executer{

	@Override
	public String getLabel() {
		return "Number of words in file";
	}

	@Override
	public Class[] getInputTypes() {
		return new Class[]{String.class};
	}

	@Override
	public FlowData execute(FlowData data) {
		String strData = data.toString();
		int numberOfWords = 1;

        for (int i = 0; i < strData.length(); i++) 
        {
            if (strData.charAt(i) == ' ') 
            {
                numberOfWords++;
            } 
        }
		return new FlowData(numberOfWords);
	}

	@Override
	public Class getOutputType() {
		return int.class;
	}
}
