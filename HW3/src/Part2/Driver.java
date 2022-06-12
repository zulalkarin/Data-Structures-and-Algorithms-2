package Part2;
//-----------------------------------------------------
//Title: Driver class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 3
//Description: Contains main method. Separate the inputs, create objects 
//-----------------------------------------------------
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);

		String auditorium = keyboard.next();
		int auditoriumNum = Integer.parseInt(auditorium);
		int[] capacities = new int[auditoriumNum];
		

		String edges = keyboard.next();
		int edgesNum = Integer.parseInt(edges);

		String distance = keyboard.next();
		int distanceNum = Integer.parseInt(distance);
		
		//System.out.println(auditoriumNum + " " + edgesNum + " " + distanceNum);

		EdgeWeightedGraph graph = new EdgeWeightedGraph(auditoriumNum); // I created new graph
		
		for(int i=0; i<auditoriumNum; i++) {
			String cap = keyboard.next();
			int capacity = Integer.parseInt(cap);
			graph.addCapacity(i, capacity);
			capacities[i] =  capacity;
			//System.out.println(capacities[i]);
		}
		
		for(int i =0; i<edgesNum; i++) {
			String node1s = keyboard.next();
			int node1 = Integer.parseInt(node1s) - 1;
			String node2s = keyboard.next();
			int node2 = Integer.parseInt(node2s) - 1;
			String dists = keyboard.next();
			int dist = Integer.parseInt(dists);

			Edge edge = new Edge(node1, node2, dist); // I created an weighted edge
			graph.addEdge(edge); // I add the edge to the graph
			
		}
		
		String participants = keyboard.next();
		int participant = Integer.parseInt(participants);
		graph.addParticipant(participant);
		//System.out.println("patricipants: " + participant);
		
		DijkstraSP sp = new DijkstraSP(graph, 0, distanceNum);

	}

}
