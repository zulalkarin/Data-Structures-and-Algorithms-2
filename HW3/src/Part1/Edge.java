package Part1;

//-----------------------------------------------------
//Title: Weighted edge class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: Initializes an weighted edge between vertices 
//-----------------------------------------------------

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final int weight;

	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int weight() {
		return weight;
	}

	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("Illegal endpoint");
	}

	public int compareTo(Edge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}

	public String toString() {
		return String.format("%d-%d %.5f", v, w, weight);
	}

	
}