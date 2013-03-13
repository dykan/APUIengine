package engine;

import genrated.Flow;
import genrated.Flow.Command;
import genrated.ObjectFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;


public class Engine {
	Flow flow;
	/*Input input;
	Output output;
	ArrayList<Executer> flow;
	
	public Flow(Input input, ArrayList<Executer> flow, Output output) {
		this.input = input;
		this.flow = flow;
		this.output = output;
	}

	public void execute(FlowData input) {
		FlowData data = this.input.Create();
		for (Executer current : flow) {
			data = current.execute(data);
		}
		
		output.write(data);
	}*/
	
	public Engine(String xml){
		StringReader xmlReader = new StringReader(xml);
		StreamSource xmlSource = new StreamSource(xmlReader);
		try{
			JAXBContext content = JAXBContext.newInstance(Flow.class);
			Unmarshaller unmarshaller = content.createUnmarshaller();
			flow = (Flow)((JAXBElement)unmarshaller.unmarshal(xmlSource,Flow.class)).getValue();
		} catch (JAXBException e){
			System.out.println("STOP");
		}
		
		List<Command> commands = 
				GraphOrder.orginizeCommands(flow.getCommand());
		
		Command c=null;
		c.getId();
		c.getNext().getId();
		
		
		
	}
}
