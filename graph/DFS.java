package com.kernel.graph;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.kernel.graph.Graph.TYPE;
public class DFS {
	private static List<Graph.Vertex> V=new ArrayList<Graph.Vertex>();
	private static List<Graph.Edge> E=new ArrayList<Graph.Edge>();
	private static Stack<Graph.Vertex> topological_order=new Stack<Graph.Vertex>();
	private static Graph graph1;
	private static List<Graph.Vertex> dfsTraversal=new  ArrayList<Graph.Vertex>();
	private static boolean visited[];
	private static int parents[];
	/**Added main method for testing purpose*/
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
		DepthFirstSearch(graph1);
		sc.close();
		for(Graph.Vertex v:dfsTraversal)
			System.out.println(v.getIndex());
	}
	private  static void dfs(Graph.Vertex v1)//for topological sorting.
	{
		if(visited[v1.getIndex()])
			return;
		else
		{
			dfsTraversal.add(v1);
			visited[v1.getIndex()]=true;
		}
		for(Graph.Edge e:v1.getEdges())
		{
			if(v1==e.getToVertex())
			{
				dfs(e.getFromVertex());
			}
			else
			dfs(e.getToVertex());
		}
		
		topological_order.push(v1);
		
	}
	private static void dfs(Graph.Vertex v1,int parent)  throws Exception //detecting cycle.
	{
		if(visited[v1.getIndex()])
			return;
		else
		{
			visited[v1.getIndex()]=true;
			for(Graph.Edge e:v1.getEdges())
			{
				if(v1==e.getToVertex())
				{
					if(visited[e.getFromVertex().getIndex()]|| e.getFromVertex().getIndex()!=parent )
					{
						throw new Exception("cycle detected");
					}
					dfs(e.getFromVertex(),v1.getIndex());
				}
				else
				{
					if(visited[e.getToVertex().getIndex()]|| e.getToVertex().getIndex()!=parent )
					{
						throw new Exception("cycle detected");
					}
					else
						dfs(e.getToVertex(),v1.getIndex());
				}
			}
		}
	}
	public static List<Graph.Vertex> DepthFirstSearch(Graph g)
	{
		visited=new boolean[g.getVertices().size()+1];
		for(Graph.Vertex v1:g.getVertices())
		{
			if(!visited[v1.getIndex()])
				dfs(v1);
		}
		return dfsTraversal;
	}
	public static void DepthFirstSearch(Graph G,int v)//for String processing(RE to NFA)
	{
		visited=new boolean[G.getVertices().size()];
		Graph.Vertex vertex=G.getVertex(v);
		dfs(vertex);
	}
	public static void DepthFirstSearch(Graph G,List<Integer> list)//for String processing(RE to NFA)
	{
		visited=new boolean[G.getVertices().size()];
		for(int v: list)
		{
		Graph.Vertex vertex=G.getVertex(v);
			if(!isMarked(v))
				dfs(vertex);	
		}
	}
	public static Stack<Graph.Vertex> topologicalSort(Graph g)
	{
		visited=new boolean[g.getVertices().size()+1];
		for(Graph.Vertex v1:g.getVertices())
		{
			if(!visited[v1.getIndex()])
				dfs(v1);
		}
		return topological_order;
	}
	public static boolean isMarked(int v)
	{
		return visited[v];
	}
	public static boolean isCyclic(Graph g)
	{	
		
		visited=new boolean[g.getVertices().size()+1];
		for(Graph.Vertex v1:g.getVertices())
		{
			if(!visited[v1.getIndex()])
				try {
					dfs(v1,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Cycle detected");
					System.exit(1);
				}
		}
		return false;
	}
}