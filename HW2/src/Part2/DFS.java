package Part2;
//-----------------------------------------------------
//Title: DFS Class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 2
//Description: This class run dfs for given vertex and find connected vertices
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class DFS {
	private boolean[] marked;
	

	public  DFS(Digraph digraph, String s, String[] chars) {  
		//This method run dfs one time for given vertex
		marked = new boolean[digraph.V()];
		dfs(digraph, s, chars);

	}

	private void dfs(Digraph G, String v, String[] chars) {
		//this method apply  topological sort algorithm to determine priority order.
		int index = Arrays.asList(chars).indexOf(v); //it is for convert string to integer		 
		marked[index] = true;
		for (String w : G.adjacentTo(v)) {
			int indexW = Arrays.asList(chars).indexOf(w);
			if (!marked[indexW])
				dfs(G, w, chars);
			
		}

	}

	public boolean marked(String v, String[] chars) { 
		//this method returns true if given vertex is marked
		int index = Arrays.asList(chars).indexOf(v);
		return marked[index];
	}


}
