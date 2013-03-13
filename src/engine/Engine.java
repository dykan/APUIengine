package engine;

import generated.Flow;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import types.BasicCommand;
import types.Executer;
import types.FlowData;
import types.MultipleExecuter;
import types.MultiplePredicate;
import types.Predicate;


public class Engine {
	private static final Integer OUTPUT_POINT = 0;

	Flow flow;
	
	HashMap<Integer, FlowData> dataMap = new HashMap<Integer, FlowData>();
	
	public Engine(String file){
		/*StringReader xmlReader = new StringReader(xml);
		StreamSource xmlSource = new StreamSource(xmlReader);
		try{
			JAXBContext content = JAXBContext.newInstance(Flow.class);
			Unmarshaller unmarshaller = content.createUnmarshaller();
			flow = (Flow)((JAXBElement)unmarshaller.unmarshal(xmlSource,Flow.class)).getValue();
		} catch (JAXBException e){
			System.out.println("STOP");
		}	*/
		flow = JAXB.unmarshal(new File(file), Flow.class);
	}
	
	public FlowData run(){	
		// init graph
		GraphOrder order = new GraphOrder(flow);
		
		// get root
		NodeCommand curr = order.getNext();
		
		while (curr != null){
			FlowData[] fatherData = getFatherData(curr);
			BasicCommand impl = curr.getImpl();
			
			// check if exec or predicate
			if (impl instanceof Executer){
				FlowData data;
				// simple or root or end
				if (curr.getPrevs().size() <= 1 || curr.getId().equals(OUTPUT_POINT)){
					data = ((Executer)impl).execute(fatherData[0]);
				// multiple data  
				} else {
					data = ((MultipleExecuter)impl).execute(fatherData);
				}
				
				// save result
				dataMap.put(curr.getId(), data);
				
			} else if (impl instanceof Predicate){
				boolean result;
				// simple or root
				if (curr.getPrevs().size() <= 1){
					result = ((Predicate)impl).execute(fatherData[0]);
				// multiple data  
				} else {
					result = ((MultiplePredicate)impl).execute(fatherData);
				}
				// save answer
				((NodePredicate)curr).setAnswer(result);
				// save data as null (if you want the data do a union)
				dataMap.put(curr.getId(), null);
			}
			
			
			curr = order.getNext();
		}
		
		// return the data in the output
		return dataMap.get(OUTPUT_POINT);

	}

	private FlowData[] getFatherData(NodeCommand curr) {
		
		// root TODO: do i need this??
		if(curr.getPrevs().size() == 0){
			return new FlowData[]{null};
		}
		ArrayList<FlowData> list = new ArrayList<FlowData>();
		for(NodeCommand father : curr.getPrevs()){
			list.add(dataMap.get(father.getId()));
		}
		
		FlowData[] array = new FlowData[list.size()];
		return list.toArray(array);
	}
}
