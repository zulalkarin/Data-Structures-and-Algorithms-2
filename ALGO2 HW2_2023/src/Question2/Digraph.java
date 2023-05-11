package Question2;
//-------------------------------------------------------------------------
//Title: Digraph Class
//Author: Cagla Kose
//ID: 10480227330
//Section: 02
//Assignment: 2 
//Question: 2
//Description: creates directed graph and run dfs for givern vertex  
//----------------------------------------------------------------------------------

import java.util.ArrayList;

public class Digraph {

	public ArrayList<Vertex> vertices;
	private boolean[] marked;
	public ArrayList<Vertex> markedVertices = new ArrayList<Vertex>();
	private int E;

	public Digraph(int V) {
		vertices = new ArrayList<>();
		marked = new boolean[V];
	}

	public int V() {
		return vertices.size();
	}

	public int E() {
		return E;
	}

	public void addEdge(Vertex v, Vertex w) {
		if (!vertices.contains(v))
			addVertex(v);
		if (!vertices.contains(w))
			addVertex(w);
		E++;
		v.neighbours.add(w);

	}

	public void addVertex(Vertex v) {
		vertices.add(v);
	}

	public void dfs(Digraph digraph, Vertex v, ArrayList<Vertex> vertices) {
		// TODO Auto-generated method stub
		marked[v.num] = true;
		markedVertices.add(v);
		// System.out.println("markedVertices.add(v): " + v.num);
		for (Vertex w : v.getNeighbours()) {
			// System.out.println("neighbour of " + v.num + " : " + w.num);
			if (!marked[w.num])
				dfs(digraph, w, vertices);

		}

	}

}