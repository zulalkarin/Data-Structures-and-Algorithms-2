//-----------------------------------------------------
// Title: Driver Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 1
// Description: This class gets inputs from user and call cycle class 
//-----------------------------------------------------
package Part1;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.next(); // first line of input
		String input2 = keyboard.next(); // second input (vertex)
		ArrayList<String> vertexArray = new ArrayList<>();

		String Edges[] = input.split(",");
		int E = Edges.length;
		Graph graph = new Graph(E); // create a graph

		for (int i = 0; i < E; i++) {
			String x = Edges[i].substring(0, 1);
			String y = Edges[i].substring(2, 3);
			// System.out.println(x + " " + y);

			if (vertexArray.isEmpty()) {
				vertexArray.add(x);
				// graph.addV();
				
			} else if (!vertexArray.contains(x)) {
				vertexArray.add(x);
				// graph.addV();
				
			}

			if (!vertexArray.contains(y)) {
				vertexArray.add(y);
				// graph.addV();
				
			}

			int v = vertexArray.indexOf(x);
			int w = vertexArray.indexOf(y);
			graph.addEdge(v, w);
			// System.out.println(v + " " + w );

		}
		System.out.println("vertices: " + vertexArray);
		int city = vertexArray.indexOf(input2);
		System.out.println("city to be controlled: " + input2);

		Cycle cycle = new Cycle(graph);
		System.out.println("has cycle: " + cycle.cycleVertices.contains(city));

		cycle.cycleVertices.remove(cycle.cycleVertices.size() - 1);

		if (cycle.hasCycle(graph) == true && cycle.cycleVertices.contains(city)) {
			System.out.println("PATH:");
			for (int i = 0; i < cycle.cycleVertices.size() - 1; i++) {

				System.out.print(vertexArray.get(cycle.cycleVertices.get(i)) + "-");
				
			}
			System.out.print((vertexArray.get(cycle.cycleVertices.size() - 1)));
			
		} else
			System.out.println("No cycle");
	}
	
	//Collections.sort(solutions); //alfabetik sýraya koyar

}
