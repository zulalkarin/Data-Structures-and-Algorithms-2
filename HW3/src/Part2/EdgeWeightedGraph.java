package Part2;

//-----------------------------------------------------
//Title: EdgeWeightedGraph class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: create an edge weighted graph 
//-----------------------------------------------------

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private LinkedList<Edge>[] adj;
	public int[] capacity;
	public int participant;

	public EdgeWeightedGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices must be non-negative");
		this.V = V;
		this.E = 0;
		this.participant =0;
		capacity =new int[V];
		adj = (LinkedList<Edge>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}
	
	public void addCapacity(int v, int cap) {
		capacity[v] = cap;
		
	}
	public void addParticipant(int part) {
		participant = part;
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	public Iterable<Edge> edges() {
		LinkedList<Edge> list = new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// add only one copy of each self loop (self loops will be consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

}
