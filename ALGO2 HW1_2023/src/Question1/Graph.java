package Question1;
//-------------------------------------------------------------------------
//Title: Graph Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 2
//Description: This class creates an undirected graph and finds  cycles which consist of minimum 5 cities. 
//----------------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.Collections;

public class Graph {

	public ArrayList<Vertex> cities;
	public ArrayList<Cycle> cycles;

	public Graph() {
		cities = new ArrayList<>();
		cycles = new ArrayList<>();
	}

	public void addEdge(char city1, char city2) {
		Vertex vertex1 = getOneVertex(city1);
		Vertex vertex2 = getOneVertex(city2);
		vertex1.neighbours.add(vertex2);
		vertex2.neighbours.add(vertex1);
	}

	public Vertex getOneVertex(char name) {
		
		for(int i=0; i<cities.size(); i++) {
			if(cities.get(i).name == name) {
				return cities.get(i);
			}
		}
		
		Vertex city = new Vertex(name);
		cities.add(city);
		return city;
	}

	public void Cycles(char city) {
		Vertex myCity = cities.get(0);
		
		for(int i=0; i<cities.size(); i++) {
			if(cities.get(i).name == city) {
				myCity = cities.get(i);
			}
		}
		
		for(int i=0; i<cities.size(); i++) {
			cities.get(i).visited = false;
		}
		
		dfs(myCity, myCity, "" + myCity.name);
		//Collections.sort(cycles); 
        if(cycles.size() == 0)
			System.out.println("No cycle");
   
        
		else if(cycles.size() == 1) {
			if(cycles.get(0).cityCount > 4 ) {
				System.out.println(cycles.get(0));
			}
			else {
				System.out.println("No cycle");
			}
		}
        
		else {
			int j =0;
			for(int i=0 ; i<cycles.size() ; i++) {
				if(cycles.get(i).getCityCount() > 4) {
					System.out.println((j+1) + ") " + cycles.get(i));
					j++;
				}
			}	
		}
	}

	public void dfs(Vertex first, Vertex second, String path) {
		int size = first.neighbours.size();
		for(int i=0; i<size; i++) {
			if(first.neighbours.get(i) == second  &&  path.length()>2) {
				Cycle newCycle = new Cycle(path);
				//System.out.println("newCycle: " + newCycle);
				if (!cycles.contains(newCycle)) {
					cycles.add(newCycle);
				}		
				
			}
			if(!path.contains("" + first.neighbours.get(i).name) )
				dfs(first.neighbours.get(i), second, path +first.neighbours.get(i).name);
		}
		
		
	}

}
