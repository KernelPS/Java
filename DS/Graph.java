

package com.kernel.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private List<Vertex> V=new ArrayList<Graph.Vertex>();
	private List<Edge> E=new ArrayList<Graph.Edge>();
	private  TYPE type=TYPE.UNDIRECTED;//default.
	public enum TYPE{
		DIRECTED,UNDIRECTED
	}
	public Graph(TYPE type)
	{
		this.type=type;
	}
	public Graph(){

	}
	public TYPE getType()
	{
		return  type;
	}
	public Graph(TYPE type,Collection<Vertex> V,Collection<Edge> E)
	{
		this(type);
		this.V.addAll(V);
		this.E.addAll(E);

		for(Edge e:E)
		{
			final Vertex from=e.from;
			final Vertex to=e.to;
			if(!this.V.contains(from) || !this.V.contains(to))
				continue;
			from.addEdge(e);
			if(this.type==TYPE.UNDIRECTED)
			{
				//Edge duplicate=new Edge(e);
				to.addEdge(e);
				//this.E.add(duplicate);
			}
		}
	}
	public Graph(TYPE type,int V)
	{
		this(type);
		for(int i=0;i<V;i++)
		{
			Vertex vertex=new Vertex(i);
			this.V.add(vertex);
		}
	}
	public void addEdge(int n1,int n2)
	{
		Vertex v1=getVertex(n1);
		Vertex v2=getVertex(n2);
		Edge edge=new Edge(v1, v2, 0);
		v1.addEdge(edge);
		E.add(edge);
	}
	public Vertex getVertex(int i)
	{
		for(Vertex v:V)
		{
			if(v.getIndex()==i)
				return v;
		}
		return null;
	}
	public List<Vertex> getVertices()
	{
		return V;
	}
	public static class Vertex implements Comparable<Vertex>{
		int index;
		int key;
		List<Edge> edges =new ArrayList<Graph.Edge>();
		public Vertex(int index) {
			this.index=index;
			// TODO Auto-generated constructor stub
		}
		public Vertex(Vertex v)
		{
			this(v.index);
			this.edges.addAll(v.edges);
		}
		public int getIndex()
		{
			return index;
		}
		public void setKey(int key)
		{
			this.key=key;
		}
		public int getKey()
		{
			return key;
		}
		public static  Vertex getVertexAt(int index,Collection<Vertex> V)
		{
			for(Vertex v:V)
			{
				if(v.getIndex()==index)
					return v;
			}
			return null;
		}
		public void addEdge(Edge e)
		{
			edges.add(e);
		}

		public List<Edge> getEdges()
		{
			return edges;
		}
		public boolean pathTo(Vertex to)
		{
			for(Edge e:edges)
			{
				if(to.equals(e.to))
					return true;
			}
			return false;
		}
		public Edge getEdge(Vertex to)
		{
			for(Edge e:edges)
				if(e.to.equals(to))
					return e;
			return null;
		}
		@Override
		public boolean equals(Object e)
		{
			if(e==null)
				return false;
			if(this==e)
				return true;
			if(!(e instanceof Vertex))
				return false;
			final Vertex e1=(Vertex)e;
			if(!(index==e1.index))
				return false;
			if(e1.edges.size()!=this.edges.size())return false;
			Iterator<Edge> iterator=this.edges.iterator();
			Iterator<Edge> iterator2=e1.edges.iterator();
			while(iterator.hasNext() && iterator.hasNext())
			{
				if((iterator.next().cost!=iterator2.next().cost))
					return false;


			}
			return true;

		}
		@Override
		public int hashCode() {
			int  code=31*index;
			return code;
		}


		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return 0;
		}


	}
	public static class Edge implements Comparable<Edge>{
		Vertex to;
		Vertex from;
		int cost;
		public Edge(Vertex from,Vertex to,int cost)
		{
			this.from=from;
			this.to=to;
			this.cost=cost;
		}
		public Edge(Edge e)
		{
			this(e.from,e.to,e.cost);
		}
		public int getCost()
		{
			return cost;
		}
		public Vertex getToVertex()
		{
			return to;
		}
		public Vertex getFromVertex()
		{
			return from;
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof Edge ))
				return false;
			Edge e1=(Edge)obj;
			if(e1.to.equals(to) && e1.from.equals(from) && e1.cost==cost)
				return true;
			return false;
		}
		@Override
		public int compareTo(Edge e) {
			if(e.cost<cost)
				return 1;
			if(e.cost>cost)
				return -1;
			return 0;
		}

	}
	public static class CostPathPair{
		private int cost;
		private List<Edge> path=null;
		public CostPathPair(int cost,List<Edge> path)
		{
			this.cost=cost;
			this.path=path;
		}	
		public int getCost()
		{
			return cost;
		}
		public List<Edge> getPath()
		{
			return path;
		}
		public void setCost(int cost)
		{
			this.cost=cost;
		}
		public void calculateCost()
		{
			for(Graph.Edge e:path)
			{
				cost=cost+e.getCost();
			}
		}
		@Override
		public boolean equals(Object obj) {
			if(! (obj instanceof CostPathPair))
				return false;
			CostPathPair pair=(CostPathPair)obj;
			if(this.cost!=pair.cost)
				return false;
			Iterator<Edge> it1=this.getPath().iterator();
			Iterator<Edge> it2=pair.getPath().iterator();
			while(it1.hasNext() &&it2.hasNext())
			{
				if(!it1.next().equals(it2.next()))
					return false;
			}
			return true;
		}
	}
}
