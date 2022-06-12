package Part1;
//-----------------------------------------------------

//Title: DirectedDFS Class
//Author: Zülal Karýn
//ID: 12622989076
//Section: 2
//Assignment: 2
//Description: This class run dfs 1 time for given course and applies topological sort
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Stack;

public class DirectedDFS {
	
	private boolean[] marked;
	public Stack<String> reversePostorder;

	public DirectedDFS(Digraph G, String s, ArrayList<String> coursesArr) {  
		//This method run dfs one time for given vertex
		reversePostorder = new Stack<String>();
		marked = new boolean[G.V()];
		dfs(G, s, coursesArr);

	}

	private void dfs(Digraph G, String v, ArrayList<String> coursesArr) {
		//this method apply  topological sort algorithm to determine priority order.
		int index = coursesArr.indexOf(v); //it is for convert string to integer
		marked[index] = true;
		for (String w : G.adjacentTo(v)) {
			int indexW = coursesArr.indexOf(w);
			if (!marked[indexW])
				dfs(G, w, coursesArr);
			reversePostorder.push(v);
		}

	}

	public boolean marked(String v, ArrayList<String> coursesArr) { 
		//this method returns true if given vertex is marked
		int index = coursesArr.indexOf(v);
		return marked[index];
	}

}
