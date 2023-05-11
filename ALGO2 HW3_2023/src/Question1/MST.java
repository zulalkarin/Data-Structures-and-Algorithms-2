package Question1;
//-------------------------------------------------------------------------
//Title: MST Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 3 
//Question: 1
//Description: this class apply Kruskal minimum spanning tree to edge weighted graph 
//----------------------------------------------------------------------------------

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {
	private static final double FLOATING_POINT_EPSILON = 1.0E-12;
	private double weight; 
	public Queue<WeightedEdge> queue = new PriorityQueue<WeightedEdge>(); 
	
	public MST(WeightedGraph G) {
		UF uf = new UF(G.V());
		WeightedEdge[] Wedges = new WeightedEdge[G.E()];
		int a = 0;
		for (WeightedEdge e : G.edges()) {
			Wedges[a++] = e;
		}
		Arrays.sort(Wedges);

		for (int i = 0; i < G.E() && queue.size() < G.V() - 1; i++) {
			WeightedEdge e = Wedges[i];
			int v = e.either();
			int w = e.other(v);
			if (uf.find(v) != uf.find(w)) {
				uf.union(v, w); 
				queue.add(e);
				weight += e.weight();
			}
		}

	}

	public Iterable<WeightedEdge> edges() {
		return queue;
	}

	public double weight() {
		return weight;
	}
	 private boolean check(WeightedGraph G) {

	        // check total weight
	        double total = 0.0;
	        for (WeightedEdge e : edges()) {
	            total += e.weight();
	        }
	        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
	            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
	            return false;
	        }

	        // check that it is acyclic
	        UF uf = new UF(G.V());
	        for (WeightedEdge e : edges()) {
	            int v = e.either(), w = e.other(v);
	            if (uf.find(v) == uf.find(w)) {
	                System.err.println("Not a forest");
	                return false;
	            }
	            uf.union(v, w);
	        }

	        // check that it is a spanning forest
	        for (WeightedEdge e : G.edges()) {
	            int v = e.either(), w = e.other(v);
	            if (uf.find(v) != uf.find(w)) {
	                System.err.println("Not a spanning forest");
	                return false;
	            }
	        }
	        return true;
	 }

}
