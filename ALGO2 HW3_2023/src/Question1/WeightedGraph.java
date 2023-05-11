package Question1;
//-------------------------------------------------------------------------
//Title: WeightedGraph Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 3 
//Question: 1
//Description: this class creates edge weighted graphs . 
//----------------------------------------------------------------------------------


import java.util.LinkedList;


public class WeightedGraph {

	private final int V;
	private int E;
	private LinkedList<WeightedEdge>[] adj;

	public WeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<WeightedEdge>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<WeightedEdge>();
		}
	}
	public Iterable<WeightedEdge> adj(int v) {
		return adj[v];
	}


	public void addEdge(WeightedEdge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}


	public Iterable<WeightedEdge> edges() {
		LinkedList<WeightedEdge> list = new LinkedList<WeightedEdge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (WeightedEdge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}


	

}
