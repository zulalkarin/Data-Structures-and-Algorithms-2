package Question1;
//-------------------------------------------------------------------------
//Title: Topological Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 2 
//Question: 1
//Description: this class make topological order 
//----------------------------------------------------------------------------------

import java.util.ArrayList;

public class Topological {
	private Iterable<String> order; // topological order

	public Topological(Digraph G, String s, ArrayList<String> courses) {
		DepthFirstOrder dfs = new DepthFirstOrder(G, s, courses);
		order = dfs.reversePost();

	}

	public Iterable<String> order() {
		return order;
	}

	public ArrayList<String> orderList() {
		ArrayList<String> arr = new ArrayList<>();
		for (String s : order) {
			arr.add(s);

		}
		return arr;
	}

	public ArrayList<String> pre() {
		ArrayList<String> arr = new ArrayList<>();
		for (String s : order) {
			arr.add(s);

		}
		return arr;
	}

	public boolean isDAG() {
		return order == null;
	}

	@Override
	public String toString() {
		return "Topological [order=" + order + "]";
	}

}
