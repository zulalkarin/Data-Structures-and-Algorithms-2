package Part2;
//-----------------------------------------------------
//Title: DijkstraSP class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: Computes a shortest-paths tree from the source vertex to every other vertex in the edge-weighted digraph 
//-----------------------------------------------------

import java.util.Stack;

public class DijkstraSP {
	private int[] distTo; // distTo[v] = distance of shortest s->v path
	private Edge[] edgeTo; // edgeTo[v] = last edge on shortest s->v path
	private IndexMinPQ<Integer> pq; // priority queue of vertices

	
	public DijkstraSP(EdgeWeightedGraph G, int s, int distance) {
		for (Edge e : G.edges()) {
			if (e.weight() < 0)
				throw new IllegalArgumentException("edge " + e + " has negative weight");
		}

		distTo = new int[G.V()];
		edgeTo = new Edge[G.V()];

		validateVertex(s);

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Integer.MAX_VALUE;
		distTo[s] = distance; 

		pq = new IndexMinPQ<Integer>(G.V());
		pq.insert(s, distTo[s]);
		while (!pq.isEmpty()) {

			int v = pq.delMin();
			for (Edge e : G.adj(v))
				relax(e, G);

		}

	}

	// relax edge e and update pq if changed
	private void relax(Edge e, EdgeWeightedGraph G) {
		int v = e.either(), w = e.other(v);
		if (distTo[w] > distTo[v] + e.weight() && G.capacity[v] == 0 && G.participant > 0) {			
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			System.out.print(distTo[w] + " ");
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
		else if (G.capacity[v] != 0) {
			System.out.print(distTo[v] + " ");
			G.capacity[v] = G.capacity[v] - 1;
			G.participant = G.participant - 1;
		}
		else {
			System.out.print( "-1 ");
		}

	}

	public double distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}

	public boolean hasPathTo(int v) {
		validateVertex(v);
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	public Iterable<Edge> pathTo(int v) {
		validateVertex(v);
		if (!hasPathTo(v))
			return null;
		Stack<Edge> path = new Stack<Edge>();
		for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.either()]) {
			path.push(e);
		}
		return path;
	}

	private void validateVertex(int v) {
		int V = distTo.length;
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

}