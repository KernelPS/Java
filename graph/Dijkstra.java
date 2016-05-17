package com.kernel.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kernel.graph.Graph.CostPathPair;
import com.kernel.graph.Graph.TYPE;
import com.kernel.graph.Graph.Vertex;

public class Dijkstra {
	private static List<Graph.Vertex> V=new ArrayList<Graph.Vertex>();
	private static List<Graph.Edge> E=new ArrayList<Graph.Edge>();
	private static Map<Graph.Vertex, CostPathPair> map=new HashMap<Graph.Vertex, Graph.CostPathPair>();
	private static Graph graph1;
	/*main method for testing purpose.*/
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
		Graph.Vertex vertex=graph1.getVertices().get(0);
		getShortestPaths(graph1, vertex);
		for(Graph.Vertex v:graph1.getVertices())
		{
			Graph.CostPathPair pair=map.get(v);
			pair.calculateCost();
			System.out.println(pair.getCost());
		}
		sc.close();
	}
	public static Map<Graph.Vertex, Graph.CostPathPair> getShortestPaths(Graph g,Graph.Vertex start)
	{
		final boolean visited[]=new boolean[g.getVertices().size()+1];
		final boolean seen[]=new boolean[g.getVertices().size()+1];
	    map=new HashMap<Graph.Vertex, Graph.CostPathPair>();
		for(Graph.Vertex vertex:g.getVertices())
		{
			vertex.setKey(Integer.MAX_VALUE);
			map.put(vertex, new Graph.CostPathPair(0, new ArrayList<Graph.Edge>()));
		}
		PrioityQueue queue=new PrioityQueue(g.getVertices().size());
		start.setKey(0);
		queue.add(start);
		visited[start.getIndex()]=true;
		while(!(queue.isEmpty()))
		{
			Graph.Vertex v=queue.getMin();//O(log n)
			visited[v.getIndex()]=true;
			for(Graph.Edge e:v.getEdges())
			{
				Vertex temp=null;
				if(e.getFromVertex()==v)
					temp=e.getToVertex();
				else
					temp=e.getFromVertex();
				if(visited[temp.getIndex()])
				{
					continue;
				}

				else
				{
					int cost=v.getKey()+e.getCost();
					if(temp.getKey()>cost)
					{
						temp.setKey(cost);
						Graph.CostPathPair path=map.get(v);
						List<Graph.Edge> E=path.getPath();
						List<Graph.Edge> E1=map.get(temp).getPath();
						E1.addAll(E);
						E1.add(e);
						if(!seen[temp.getIndex()])
						{
							queue.add(temp);
							seen[temp.getIndex()]=true;
						}
					}

				}
			}

		}

		return map	;
	}



}
class PrioityQueue 
{
	int size=0;
	static int n=0;
	Graph.Vertex a[];
	public void add(Graph.Vertex v)
	{
		n++;
		a[n]=v;
		floatUp(n);
	}
	public PrioityQueue(int size) {
		this.size=size;
		a=new Graph.Vertex[size+1];
		// TODO Auto-generated constructor stub
	}
	public void floatUp(int k)
	{
		int j=k/2;
		while(j>=1)
		{
			if(a[j].key>a[k].key)
				swap(j,k);
			k=j;
			j=k/2;
		}
	}
	public Graph.Vertex getMin()
	{
		Graph.Vertex min=a[1];
		a[1]=a[n];
		n--;
		sinkDown(1);
		return min;
	}
	public void sinkDown(int k)
	{
		int j=k;
		while(2*j<=n)
		{
			j=2*k;
			if(2*j<n && a[j+1].key<a[j].key)j++;
			if(a[j].key<a[k].key)
				swap(j,k);
			k=j;

		}
	}
	public void swap(int j,int k)
	{
		Graph.Vertex temp=a[j];
		a[j]=a[k];
		a[k]=temp;
	}
	public boolean isEmpty()
	{
		return (n==0);
	}
}