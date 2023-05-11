package Question2;
//-------------------------------------------------------------------------
//Title: Vertex Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 2
//Description: This class's main purpose is determine the vertices neighbouring vertices 
//----------------------------------------------------------------------------------

import java.util.ArrayList;

public class Vertex {

	public char name;
	public ArrayList<Vertex> neighbours;
	public boolean visited;
	
	public Vertex(char l) {
		name = l;
		neighbours = new ArrayList<>();
		visited = false;
	}
	
	public char getName() {
		return name;
	}

	public void setLetter(char name) {
		this.name = name;
	}

	public ArrayList<Vertex> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<Vertex> neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
