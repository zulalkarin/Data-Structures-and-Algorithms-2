package Part2;
//-----------------------------------------------------
//Title: Digraph Class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 2
//Description: This class creates an directed graph
//-----------------------------------------------------


public class Digraph {

	// symbol table: key = string vertex, value = set of neighboring vertices
	private ST<String, SET<String>> st;

	// number of edges
	private int E;

	// Initializes an empty graph with no vertices or edges.

	public Digraph() {
		st = new ST<String, SET<String>>();
	}

	public int V() {
		return st.size();
	}

	public int E() {
		return E;
	}

	// throw an exception if v is not a vertex
	private void validateVertex(String v) {
		if (!hasVertex(v))
			throw new IllegalArgumentException(v + " is not a vertex");
	}

	public int degree(String v) {
		validateVertex(v);
		return st.get(v).size();
	}

	public void addEdge(String v, String w) {
		if (!hasVertex(v))
			addVertex(v);
		if (!hasVertex(w))
			addVertex(w);
		if (!hasEdge(v, w))
			E++;
		st.get(v).add(w);
	}

	public void addVertex(String v) {
		if (!hasVertex(v))
			st.put(v, new SET<String>());
	}
	

	public Iterable<String> vertices() {
		return st.keys();
	}

	public Iterable<String> adjacentTo(String v) {
		validateVertex(v);
		return st.get(v);
	}

	public boolean hasVertex(String v) {
		return st.contains(v);
	}

	public boolean hasEdge(String v, String w) {
		validateVertex(v);
		validateVertex(w);
		return st.get(v).contains(w);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (String v : st) {
			s.append(v + ": ");
			for (String w : st.get(v)) {
				s.append(w + " ");
			}
			s.append('\n');
		}
		return s.toString();
	}

}
