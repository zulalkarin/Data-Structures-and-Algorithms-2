//-----------------------------------------------------
// Title: Graph Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 1
// Description: This class creates an Undirected graph  
//-----------------------------------------------------
package Part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
	
	private static int V;  
	private int E;	   
    public LinkedList<Integer>[] adj_list; 
   
     
    
    public Graph(int V) { 
        this.V = V;
        this.E =E;
        adj_list = new LinkedList[V]; 
        for (int i=0; i<V; ++i) 
            adj_list[i] = new LinkedList(); 
    } 
    
    
    public void addV() {
         V = V+1;
    }
    
    public int V() {
        return V;
    }
    
   
    //add an edge to the graph 
   public void addEdge(int v, int w) { 
    	E++;
        adj_list[v].add(w);  // Add w to v's list. 
        adj_list[w].add(v);
        
    }
    
    
    public Iterable<Integer> adj(int v) 
    {  return adj_list[v];  }
    
     
 
}
