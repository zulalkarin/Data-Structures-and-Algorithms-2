package Question2;
//-------------------------------------------------------------------------
//Title: Driver Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 2
//Description: This class gets the inputs and calls method that helps us to find paths between vertices
//----------------------------------------------------------------------------------

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		 Scanner keyboard = new Scanner(System.in);
		 Graph graph = new Graph();
		 
		 String paths = keyboard.nextLine();
		 String Edges[] = paths.split(",");
		 String city1 = keyboard.nextLine();
		 String city2 = keyboard.nextLine();
		 
		
		 for(int i =0; i<Edges.length; i++) {
				char vertex1 = Edges[i].charAt(0);
				char vertex2 = Edges[i].charAt(2);
				graph.addEdge(vertex1, vertex2);
			}

		graph.pathFinder(city1.charAt(0), city2.charAt(0));
	}

}
