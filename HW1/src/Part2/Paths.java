//-----------------------------------------------------
// Title: Paths Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 1
// Description: This class find paths particular length.  
//-----------------------------------------------------
package Part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Paths {

	private Stack<Integer> path = new Stack<Integer>(); // the current path
	private ArrayList<Integer> onPath = new ArrayList<Integer>(); // the set of vertices on the path
	private ArrayList<Integer> outputs = new ArrayList<Integer>(); // the set of vertices on the path
	

	public Paths(Graph G, int s, int t, int dist) {
		enumerate(G, s, t, dist);
	}
	public boolean flag =false;

	// use DFS
	private void enumerate(Graph G, int v, int t, int dist) {

		// add node v to current path from s
		path.push(v);
		onPath.add(v);
		

		// found path from s to t - currently prints in reverse order because of stack
		if (v == t && path.size()==dist) {
			Collections.sort(path);
			System.out.println(path);
			flag = true;
			
			 
		}

		// consider all neighbors that would continue path with repeating a node
		else {
			for (int w : G.adj(v)) {
				if (!onPath.contains(w))
					enumerate(G, w, t, dist);				
			}
		}

		// done exploring from v, so remove from path
		path.pop();
		onPath.remove(v);
		
		
	}
}
