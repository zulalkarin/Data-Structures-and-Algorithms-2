package Question1;

//-------------------------------------------------------------------------
//Title: WeightedEdge Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 3 
//Question: 1
//Description: this class initializes weighted edges between vertices . 
//----------------------------------------------------------------------------------


public class WeightedEdge implements Comparable<WeightedEdge> {

	private final int v;
	private final int w;
	private final int weight;

	public WeightedEdge(int v, int w, int weight) {
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

	public int compareTo(WeightedEdge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}



	
}