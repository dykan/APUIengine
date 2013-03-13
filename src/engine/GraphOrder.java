package engine;

import generated.Flow;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import types.Predicate;

public class GraphOrder {
	
	private GraphCommand graph;
	private Queue<NodeCommand> queue;
	private Set<NodeCommand> evaluated;
	private NodePredicate lastPredicate = null;
	public GraphOrder(GraphCommand graph) {
		this.graph = graph;
		this.evaluated = new HashSet<>();
		queue = new LinkedBlockingQueue<NodeCommand>();
		this.fillStarts();
	}
	
	public GraphOrder(Flow flow) {
		this(new GraphCommand(flow));
	}

	public NodeCommand getNext() {
		// check if we are waiting for answer from predicate
		if (lastPredicate !=null){
			if(lastPredicate.getAnswer())
			{
				this.queue.add(lastPredicate.getTrueCommand());
			}
			else
			{
				this.queue.add(lastPredicate.getFalseCommand());
			}
			lastPredicate = null;
		}
		NodeCommand current = queue.poll();
		if(NodeExecuter.class.isInstance(current))
		{
			this.evaluated.add(current);
			for(NodeCommand next : ((NodeExecuter)current).outEdges)
			{
				if(evaluated.containsAll(next.prevEdges))
				{
					this.queue.add(next);
				}
			}
		}
		else if(NodePredicate.class.isInstance(current))
		{
			lastPredicate = (NodePredicate)current;
		}
		
		return current;
	}
	
	private void fillStarts() {
		for (NodeCommand cmd : graph.vertices.values()) {
			if(cmd.prevEdges.size() == 0) {
				this.queue.add(cmd);
			}
		}
	}
}
