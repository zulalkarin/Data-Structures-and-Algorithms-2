package Part1;

//-----------------------------------------------------
//Title: KruskalMST class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: Compute a minimum spanning tree of an edge-weighted graph.
//-----------------------------------------------------

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {

	private double weight; // weight of MST
	public Queue<Edge> mst = new PriorityQueue<Edge>(); // edges in MST

	public KruskalMST(EdgeWeightedGraph G) {

		// create array of edges, sorted by weight
		Edge[] edges = new Edge[G.E()];
		int t = 0;
		for (Edge e : G.edges()) {
			edges[t++] = e;
		}
		Arrays.sort(edges);

		// run greedy algorithm
		UF uf = new UF(G.V());
		for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
			Edge e = edges[i];
			int v = e.either();
			int w = e.other(v);

			// v-w does not create a cycle
			if (uf.find(v) != uf.find(w)) {
				uf.union(v, w); // merge v and w components
				// mst.enqueue(e);
				mst.add(e);// add edge e to mst
				weight += e.weight();
			}
		}

	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

}