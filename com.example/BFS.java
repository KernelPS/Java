package com.kernel.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.kernel.graph.Graph.TYPE;

public class BFS {
	static List<Graph.Vertex> V=new ArrayList<Graph.Vertex>();
	static List<Graph.Edge> E=new ArrayList<Graph.Edge>();
	static Graph graph1;
	private static List<Graph.Vertex> bfsTraversal=new  ArrayList<Graph.Vertex>();
	private static boolean visited[];
	private static LinkedList<Graph.Vertex> queue=new LinkedList<Graph.Vertex>();
	/*Main method for testing purpose.*/
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the graph,press -1 once done");
		while(true)
		{
			int v1=sc.nextInt();
			if(v1==-1)
				break;
			int v2=sc.nextInt();
			int cost=sc.nextInt();
			Graph.Vertex from=new Graph.Vertex(v1);
			Graph.Vertex to=new Graph. Vertex(v2);
			if(!V.contains(from) && !V.contains(to))
			{
				V.add(from);
				V.add(to);
				E.add(new Graph.Edge(from,to,cost));
				
			}
			else if(!(V.contains(from)) && V.contains(to))
			{
				V.add(from);
				E.add(new Graph.Edge(from,Graph.Vertex.getVertexAt(to.getIndex(), V),cost));
			}
			else if(V.contains(from) && !V.contains(to))
			{
				V.add(to);
				E.add(new Graph.Edge(Graph.Vertex.getVertexAt(from.getIndex(), V),to,cost));
			}
			else if(V.contains(from ) && V.contains(to))
			{
				E.add(new Graph.Edge(Graph.Vertex.getVertexAt(from.getIndex(), V),Graph.Vertex.getVertexAt(to.getIndex(), V),cost));
			}
			
		}
		graph1=new Graph(TYPE.UNDIRECTED, V, E);
		breadthFirstSearch(graph1);
		for(Graph.Vertex v:bfsTraversal)
			System.out.println(v.getIndex());
		
		
}
	public static List<Graph.Vertex> breadthFirstSearch(Graph g)
	{
		visited=new boolean[g.getVertices().size()+1];
		Graph.Vertex v=g.getVertices().get(0);
		queue.addLast(v);
		while(!queue.isEmpty())
		{
			Graph.Vertex v1=queue.removeFirst();
			if(!visited[v1.getIndex()])
			{
				visited[v1.getIndex()]=true;
				bfsTraversal.add(v1);
				for(Graph.Edge e:v1.getEdges())
				{
					if(v1==e.getToVertex())
					{
						if(!visited[e.getFromVertex().getIndex()])
							queue.addLast(e.getFromVertex());
							
					}
					else
					{
						if(!visited[e.getToVertex().getIndex()])
							queue.addLast(e.getToVertex());
					}
				}
			}
		}
		return bfsTraversal;
	}
	public void BFS(Graph.Vertex v)
	{
		
	}
}

