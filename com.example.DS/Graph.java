

package com.kernel.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Graph {
	private List<Vertex> V=new ArrayList<Graph.Vertex>();
	private List<Edge> E=new ArrayList<Graph.Edge>();//default;
	public enum TYPE{
		DIRECTED,UNDIRECTED
	}
	public Graph(TYPE type)
	{
		this.type=type;
	}
	private TYPE type=TYPE.UNDIRECTED;
	public Graph(){

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
	public List<Vertex> getVertices()
	{
		return V;
	}
	public static class Vertex implements Comparable<Vertex>{
		int index;
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
				if(!(iterator.next().cost!=iterator2.next().cost))
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
}
