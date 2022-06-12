package Part1;

//-----------------------------------------------------
//Title: EdgeWeightedGraph and main class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: contains main method and create graph 
//-----------------------------------------------------

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class EdgeWeightedGraph {

	private final int V;
	private int E;
	private LinkedList<Edge>[] adj;

	public EdgeWeightedGraph(int V) {
		if (V < 0)
			throw new IllegalArgumentException("Number of vertices must be non-negative");
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Edge>[]) new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	public Iterable<Edge> edges() {
		LinkedList<Edge> list = new LinkedList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// add only one copy of each self loop (self loops will be consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);

		String students = keyboard.next();
		int studentsNum = Integer.parseInt(students);

		String connections = keyboard.next();
		int connectionsNum = Integer.parseInt(connections);

		String queries = keyboard.next();
		int queriesNum = Integer.parseInt(queries);

		EdgeWeightedGraph graph = new EdgeWeightedGraph(studentsNum); // I created new graph

		for (int i = 0; i < connectionsNum; i++) { // this for loop takes C input and create an weighted undirected
													// graph
			String comp1s = keyboard.next();
			int comp1 = Integer.parseInt(comp1s) - 1;
			String comp2s = keyboard.next();
			int comp2 = Integer.parseInt(comp2s) - 1;
			String dists = keyboard.next();
			int dist = Integer.parseInt(dists);

			Edge edge = new Edge(comp1, comp2, dist); // I created an weighted edge
			graph.addEdge(edge); // I add the edge to the graph

		}

		KruskalMST mst = new KruskalMST(graph); // I created new minnimum spanning tree from my graph
		int mstEdgesSize = mst.mst.size();
		// System.out.println("MST edges count: " + mstEdgesSize);

		// System.out.println(mst.mst.toString());

		EdgeWeightedGraph newGraph = new EdgeWeightedGraph(studentsNum); // create a new graph wich contains mst edges

		for (int i = 0; i < mstEdgesSize; i++) {
			newGraph.addEdge(mst.mst.poll()); // add edges to new graph
		}

		// System.out.println("new graph Numedges: " + newGraph.E());

		for (int j = 0; j < queriesNum; j++) {
			String comp1s = keyboard.next();
			int comp1 = Integer.parseInt(comp1s) - 1;
			String comp2s = keyboard.next();
			int comp2 = Integer.parseInt(comp2s) - 1;

			BreadthFirstPaths bfs = new BreadthFirstPaths(newGraph, comp1);
			// System.out.println("has path to: " + bfs.hasPathTo(comp2));
			System.out.println(bfs.distTo(comp2));

		}

	}

}
