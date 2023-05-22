package Question1;


public class Digraph {

	private ST<String, SET<String>> st;
	private int E;


	public Digraph() {
		st = new ST<String, SET<String>>();
	}


	public Iterable<String> adjacentTo(String v) {	
		return st.get(v);
	}


	public int degree(String v) {
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

	
	public boolean hasVertex(String v) {
		return st.contains(v);
	}

	public boolean hasEdge(String v, String w) {
		return st.get(v).contains(w);
	}
	
	public int V() {
		return st.size();
	}

	public int E() {
		return E;
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
