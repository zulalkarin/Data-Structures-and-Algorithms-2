package Part1;

//-----------------------------------------------------

//Title: BredthFirstPath class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: Computes the shortest path between the source vertex and every other vertex in the graph 
//-----------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges shortest s-v path

	public BreadthFirstPaths(EdgeWeightedGraph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		validateVertex(s);
		bfs(G, s);

	}

	private void bfs(EdgeWeightedGraph G, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int v = 0; v < G.V(); v++)
			distTo[v] = INFINITY;
		distTo[s] = 0;
		marked[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int v = q.remove();
			for (Edge w : G.adj(v)) {
				if (!marked[w.other(v)]) {
					edgeTo[w.other(v)] = v;
					distTo[w.other(v)] = distTo[v] + w.weight();
					marked[w.other(v)] = true;
					q.add(w.other(v));
				}
			}
		}
	}

	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		int V = marked.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

}
