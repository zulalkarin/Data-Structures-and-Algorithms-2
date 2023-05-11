package Question2;
//-------------------------------------------------------------------------
//Title: Graph Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 2
//Description: This class creates an undirected graph and finds all paths between two vertices by using bfs. Also, it prits the paths
//----------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Graph {

	public ArrayList<Vertex> cities;
	public ArrayList<Path> paths;

	public Graph() {
		cities = new ArrayList<>();
		paths = new ArrayList<>();
	}

	public void addEdge(char city1, char city2) {
		Vertex vertex1 = getOneVertex(city1);
		Vertex vertex2 = getOneVertex(city2);
		vertex1.neighbours.add(vertex2);
		vertex2.neighbours.add(vertex1);
	}

	public Vertex getOneVertex(char name) {

		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).name == name) {
				return cities.get(i);
			}
		}

		Vertex city = new Vertex(name);
		cities.add(city);
		return city;
	}

	public void pathFinder(char first, char second) {
		Vertex source = getOneVertex(first);
		Vertex destination = getOneVertex(second);

		for (int i = 0; i < cities.size(); i++) {
			cities.get(i).visited = false;
		}

		for (int i = 1; i < 5; i++) {
			bfs(source, destination, "" + source.name, i);

		}
		
		 ArrayList<Path> newpaths = sortPaths(paths);
	

		if (newpaths.size() == 0) {
			System.out.println("No path");

		}
		
		for(int i=0 ; i<newpaths.size() ; i++)
			System.out.println(newpaths.get(i));

	}

	public void bfs(Vertex source, Vertex destination, String path, int count) {
		int size = source.neighbours.size();
		for (int j = 0; j < size; j++) {
			if (source.neighbours.get(j) == destination && path.length() == count - 1
					&& !path.contains("" + source.neighbours.get(j).name)) {

				Path newPath = new Path(path + source.neighbours.get(j).name);
				if (!paths.contains(newPath))
					paths.add(newPath);
			}
			if (!path.contains("" + source.neighbours.get(j).name))
				bfs(source.neighbours.get(j), destination, path + source.neighbours.get(j).name, count);

		}

	}
	
	public ArrayList<Path> sortPaths(ArrayList<Path> paths){
		ArrayList<Path> pathsWith2Vertices = new ArrayList<Path>();
		ArrayList<Path> pathsWith3Vertices = new ArrayList<Path>();
		ArrayList<Path> pathsWith4Vertices = new ArrayList<Path>();
		
		for(int i=0; i<paths.size(); i++) {
			if(paths.get(i).vertexCount ==2) {
				pathsWith2Vertices.add(paths.get(i));
			}
			if(paths.get(i).vertexCount ==3) {
				pathsWith3Vertices.add(paths.get(i));
			}
			if(paths.get(i).vertexCount ==4) {
				pathsWith4Vertices.add(paths.get(i));
			}
			
		}
		Collections.sort(pathsWith2Vertices);
		Collections.sort(pathsWith3Vertices);
		Collections.sort(pathsWith4Vertices);
		
		ArrayList<Path> combinedList = (ArrayList<Path>) Stream.of(pathsWith2Vertices, pathsWith3Vertices,pathsWith4Vertices )
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
		
		
		return combinedList;
	}

}
