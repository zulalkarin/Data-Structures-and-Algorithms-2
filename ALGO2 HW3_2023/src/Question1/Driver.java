package Question1;


import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {

		ArrayList<String> nodeArr = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		String streets = scan.next();
		String paths = scan.next();
		
		int streetNum = Integer.parseInt(streets);
		int pathNum = Integer.parseInt(paths);

		
		WeightedGraph myGraph = new WeightedGraph(streetNum); // I created new graph
		WeightedGraph myGraph2 = new WeightedGraph(streetNum); // create a new graph wich contains mst edges
		

		for (int i = 0; i < pathNum; i++) { // this for loop takes C input and create an weighted undirected
													// graph
			String firstStreet = scan.next();
			if(!nodeArr.contains(firstStreet)) {
				nodeArr.add(firstStreet);
			}
			
			
			int firstStreeti =nodeArr.indexOf(firstStreet);
			String secondStreet = scan.next();
			if(!nodeArr.contains(secondStreet)) {
				nodeArr.add(secondStreet);
			}
			
			int secondStreeti =nodeArr.indexOf(secondStreet);
			String distsance = scan.next();
			int distance = Integer.parseInt(distsance);

			WeightedEdge newEdge = new WeightedEdge(firstStreeti, secondStreeti, distance); // I created an weighted edge
			myGraph.addEdge(newEdge); // I add the edge to the graph

		}

		MST minimumSpanning = new MST(myGraph); // I created new minnimum spanning tree from my graph
		int minimumSpanningEdges = minimumSpanning.queue.size();

		for (int i = 0; i < minimumSpanningEdges; i++) {
			myGraph2.addEdge(minimumSpanning.queue.poll()); // add edges to new graph
		}

		
		while(scan.nextLine() != null) {
			String firstStreet = scan.next();
			int firstStreestint= nodeArr.indexOf(firstStreet);
			String secondSteet = scan.next();	
			int secondStreetint= nodeArr.indexOf(secondSteet);
			BFSPaths bfs = new BFSPaths(myGraph2, firstStreestint);	
			System.out.println(bfs.distTo(secondStreetint));
		}
			
		
	}

}
