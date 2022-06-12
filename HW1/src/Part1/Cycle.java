//-----------------------------------------------------
// Title: Cycle Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 1
// Description: This class finds the cycles  
//-----------------------------------------------------
package Part1;

import java.util.ArrayList;

public class Cycle {
	public boolean[] marked;
	public boolean hasCycle;
	ArrayList<Integer> cycleVertices = new ArrayList<>(); // this arraylist holds the vertices which is part of a cycle
															// in the graph

	public Cycle(Graph G) {
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++) {
			if (!marked[s])
				dfs(G, s, s);
		}

	}

	public void dfs(Graph G, int v, int u) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w, v);
			else if (w != u) {
				hasCycle = true;
				cycleVertices.add(w); //(a,c)
				//cycleVertices.add(v);// (c,a)
				cycleVertices.add(u); // (b,a)

			}
		}
	}

	public boolean hasCycle(Graph G) {
		return hasCycle;
	}

}
