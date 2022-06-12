//-----------------------------------------------------
// Title: Driver Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 1
// Description: This class gets input from user and use Graph paths class 
//-----------------------------------------------------
package Part2;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
        String input= keyboard.next(); //first line of input         
        String city1 =keyboard.next(); //first city
        String city2 =keyboard.next(); //second city
        String distance =keyboard.next();
        int dist = Integer.parseInt(distance); 
        ArrayList <String> vertexArray = new ArrayList<>();
        
       
        String Edges[] = input.split(","); 
        int E = Edges.length;
        Graph graph = new Graph(E); //create a graph
         
        
        for(int i=0; i<E; i++) {
        	String x = Edges[i].substring(0, 1);
        	String y = Edges[i].substring(2, 3);
        	
        	
        	if(vertexArray.isEmpty()) {        		
        		vertexArray.add(x);
        		graph.addV();
        		
        	}
        	else if(!vertexArray.contains(x)) {
        		vertexArray.add(x);
        		graph.addV();
        		
        	}
        	
            if(!vertexArray.contains(y)) {
        		vertexArray.add(y);
        		graph.addV();
        		
        	}
            
        	int v =vertexArray.indexOf(x);
        	int w = vertexArray.indexOf(y);        	
        	graph.addEdge(v,w);
        	//System.out.println(v + " " + w );
        	
        }
        System.out.println("vertices: " + vertexArray);
        System.out.println("city 1: " + city1);
        System.out.println("city 2: " + city2);
        System.out.println("distance between cities: " + distance);

        int v = vertexArray.indexOf(city1);
        int t =vertexArray.indexOf(city2);
        
        Paths paths =new Paths(graph,v, t, dist);
        if(paths.flag ==false) 
			System.out.println("No path.");       
	
  }
}