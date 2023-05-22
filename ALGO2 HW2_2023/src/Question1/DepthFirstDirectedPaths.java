package Question1;


import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstDirectedPaths {
    private boolean[] marked;  // marked[v] = true iff v is reachable from s
    private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
    private final String s;       // source vertex

    
    public DepthFirstDirectedPaths(Digraph G, String s, ArrayList<String> courses ) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;   
        dfs(G, s, courses);
    }

    private void dfs(Digraph G, String v, ArrayList<String> courses) {
    	int index = courses.indexOf(v);
    	marked[index] = true;
        for (String w : G.adjacentTo(v)) {
        	int indexW = courses.indexOf(w);
            if (!marked[indexW]) {
                edgeTo[indexW] = index;
                dfs(G, w, courses);
            }
        }
    }

    
    public boolean hasPathTo(String v, ArrayList<String> coursesArr ) {
    	int index = coursesArr.indexOf(v);
        return marked[index];
    }



}
