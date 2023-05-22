package Question1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	// private Queue<String> pre; // vertices in preorder
	Queue<String> pre = new LinkedList<>();
	// private Queue<String> post; // vertices in postorder
	Queue<String> post = new LinkedList<>();
	private Stack<String> reversePost; // vertices in reverse postorder

	public DepthFirstOrder(Digraph G, String s, ArrayList<String> courses) {
		pre = new LinkedList<String>();
		// pre = new LinkedList<String>();
		// post = new Queue<String>();
		post = new LinkedList<String>();
		reversePost = new Stack<String>();
		marked = new boolean[G.V()];
		// dfs(G, s, coursesArr);

		for (int v = 0; v < G.V(); v++)
			if (!marked[v]) {
				String strV = courses.get(v);
				dfs(G, strV, courses);
			}

	}

	private void dfs(Digraph G, String v, ArrayList<String> courses) {
		// pre.enqueue(v);
		pre.add(v);
		int index = courses.indexOf(v); // it is for convert string to integer
		marked[index] = true;
		for (String w : G.adjacentTo(v)) {
			int indexW = courses.indexOf(w);
			if (!marked[indexW])
				dfs(G, w, courses);

		}
		reversePost.push(v);
		post.add(v);

	}

	public boolean marked(String v, ArrayList<String> courses) {
		// this method returns true if given vertex is marked
		int index = courses.indexOf(v);
		return marked[index];
	}

	public Iterable<String> pre() {
		return pre;
	}

	public Iterable<String> post() {
		return post;
	}

	public Iterable<String> reversePost() {
		return reversePost;
	}

}
