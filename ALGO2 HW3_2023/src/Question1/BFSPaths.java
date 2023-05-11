package Question1;

//-------------------------------------------------------------------------
//Title: Driver Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 3 
//Question: 1
//Description: this class finds the the shortest path between the source vertex to every other vertices. 
//----------------------------------------------------------------------------------


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSPaths {
	private boolean[] marked; // marked[v] = is there an s-v path
	private int[] edgeTo; // edgeTo[v] = previous edge on shortest s-v path
	private int[] distTo; // distTo[v] = number of edges shortest s-v path
	Queue<Integer> queue = new LinkedList<Integer>();

	public BFSPaths(WeightedGraph G, int s) {
		marked = new boolean[G.V()];
		distTo = new int[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);

	}
	
	public int distTo(int v) {
		return distTo[v];
	}


	private void bfs(WeightedGraph G, int s) {
		
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Integer.MAX_VALUE;
		distTo[s] = 0;
		marked[s] = true;
		queue.add(s);
		while (!queue.isEmpty()) {
			int v = queue.remove();
			for (WeightedEdge w : G.adj(v)) {
				if (!marked[w.other(v)]) {
					edgeTo[w.other(v)] = v;
					distTo[w.other(v)] = distTo[v] + w.weight();
					marked[w.other(v)] = true;
					queue.add(w.other(v));
				}
			}
		}
	}


}
