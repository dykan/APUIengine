package engine;

import generated.Flow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphOrder {
	private GraphCommand graph;
	private Queue<NodeCommand> queue;
	private Set<NodeCommand> evaluated;
	private Set<NodeCommand> inPath;
	private NodePredicate lastPredicate = null;
	public GraphOrder(GraphCommand graph) {
		this.graph = graph;
		this.evaluated = new HashSet<>();
		this.queue = new LinkedList<NodeCommand>();
		this.inPath = new HashSet<NodeCommand>();
		this.fillStarts();
	}

	public GraphOrder(Flow flow) {
		this(new GraphCommand(flow));
	}

	public NodeCommand getNext() {
		inPath.clear();
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
		if(current instanceof NodeExecuter)
		{
			this.evaluated.add(current);
			for(NodeCommand next : ((NodeExecuter)current).outEdges)
			{
				if(this.canRun(next))
				{
					this.queue.add(next);
				}
			}
		}
		else if(current instanceof NodePredicate)
		{
			lastPredicate = (NodePredicate)current;
		}

		return current;
	}

	private boolean isRoot(NodeCommand command)
	{
		return (command.prevEdges.isEmpty());
	}

	private boolean canRun(NodeCommand command)
	{
		if(!inPath.contains(command))
		{	
			inPath.add(command);
			if(evaluated.contains(command))
			{
				return true;
			}
			else if(isRoot(command))
			{
				return false;
			}
			else
			{
				for(NodeCommand prev : command.prevEdges)
				{
					if(!canRun(prev))
						return false;
				}

				return true;
			}
		}
		else
		{
			return true;
		}
	}

	private void fillStarts() {
		for (NodeCommand cmd : graph.vertices.values()) {
			if(isRoot(cmd)) {
				this.queue.add(cmd);
			}
		}
	}
}
