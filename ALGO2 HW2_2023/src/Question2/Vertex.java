package Question2;
//-------------------------------------------------------------------------
//Title: Vertex Class
//Author: Cagla Kose
//ID: 10480227330
//Section: 02
//Assignment: 2 
//Question: 2
//Description: creates vertex object with index and name variables.   
//----------------------------------------------------------------------------------

import java.util.ArrayList;


public class Vertex {

	public String name;
	public int num;
	public ArrayList<Vertex> neighbours;
	public boolean visited;
	
	public Vertex(int num, String name) {
		this.name = name;
		this.num = num;
		neighbours = new ArrayList<>();
		visited = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Vertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Vertex> neighbours) {
		this.neighbours = neighbours;
	}

	
	
}
	