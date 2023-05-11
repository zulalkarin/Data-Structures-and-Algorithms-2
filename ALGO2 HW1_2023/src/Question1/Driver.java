package Question1;
//---------------------------------------------------------------------------
//Title: Driver Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 1
//Description: This class gets the inputs and calls method that helps us to find cycles which contains given city
//-------------------------------------------------------------------------------------

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		 Scanner keyboard = new Scanner(System.in);
		 Graph graph = new Graph(); //create new undirected graph
		 
		 String paths = keyboard.next(); // first line of input
		 String city = keyboard.next(); // second line of input
		 char ccity = city.charAt(0);
	
		String Edges[] = paths.split(",");
		
		for(int i =0; i<Edges.length; i++) {
			char city1 = Edges[i].charAt(0);
			char city2 = Edges[i].charAt(2);
			graph.addEdge(city1, city2);
		}
	
		graph.Cycles(ccity);
	}

}
