package com.kernel.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import com.kernel.graph.Graph.TYPE;
import com.kernel.graph.Graph.Vertex;

public class TopologicalSort {
	static List<Graph.Vertex> V=new ArrayList<Graph.Vertex>();
	static List<Graph.Edge> E=new ArrayList<Graph.Edge>();
	static Graph graph;
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
		graph=new Graph(TYPE.DIRECTED, V, E);//UNDIRECCTED or DIRECTED.
		Stack<Graph.Vertex> tSort=null;
		if(!DFS.isCyclic(graph)){
			tSort=DFS.topologicalSort(graph);//topological ordering using DFS.(post order).
			while(!tSort.isEmpty())
				System.out.println(tSort.pop().index);
		}



	}

}
