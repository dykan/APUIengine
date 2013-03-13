package engine;

import engine.GraphOrder;
import genrated.Flow;
import genrated.Flow.Command;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import types.BasicCommand;
import types.Executer;
import types.FlowData;
import types.Predicate;


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
		
		
	}
	
	public FlowData run(){
		
		// init data
		FlowData data = new FlowData(null);
		
		// init grapg
		GraphOrder order = new GraphOrder(flow);
		
		NodeCommand curr = order.getNext();
		
		while (curr != null){
			BasicCommand impl = curr.getImpl();
			// check if exec or predicate
			if (impl instanceof Executer){
				data = ((Executer)impl).execute(data);
			} else if (impl instanceof Predicate){
				order.setAnswer(((Predicate)impl).execute(data));
			}
			
			order.setExecuted();
			curr = order.getNext();
		}
		
		
		return data;
	}
}
