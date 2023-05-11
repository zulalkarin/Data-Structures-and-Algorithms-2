package Question2;
//-------------------------------------------------------------------------

//Title: Driver Class
//Author: Cagla Kose
//ID: 10480227330
//Section: 02
//Assignment: 2 
//Question: 2
//Description: takes input, creates directed graph.  
//----------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static ArrayList<Vertex> vertices = new ArrayList<Vertex>();



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		int row = keyboard.nextInt(); // number of rows
		int column = keyboard.nextInt(); // number of columns

		String[] lines = new String[row]; // values in a row

		Digraph digraph = new Digraph(row * column);

		keyboard.nextLine();

		for (int i = 0; i < row; i++) {
			String rows = keyboard.nextLine(); // S S S S
			lines[i] = rows;
			// System.out.println(lines[i]);
		}

		for (int i = 0; i < lines.length; i++) {
			String[] chars = new String[column]; // S's and O's in a line
			chars = lines[i].split(" ");
			for (int a = 0; a < chars.length; a++) {
				Vertex vertex = new Vertex((a + i * column), chars[a]);
				vertices.add(vertex);
				Vertex newVertex = new Vertex((a + i * column), chars[a]);
				// System.out.println("id: " + newVertex.num + " name: " + newVertex.name);
			}

		}

		DigraphHelper(digraph, lines, column);
		// System.out.println("vertices: " + digraph.V());
		// System.out.println("edges: " + digraph.E());

		// digraph.dfs(digraph, vertices.get(4), vertices);
		// System.out.println("size: " + digraph.markedVertices.size());

		for (Vertex v : vertices) {

			if (((v.num < column) || (column * row - column - 1 < v.num && v.num < column * row))
					&& v.name.equals("O")) {
				// System.out.println("deneme1: " + v.num);
				digraph.dfs(digraph, v, vertices);
			}

			for (int i = 0; i < row; i++) {
				if (((v.num == i * column + column - 1) || (v.num == i * column + column)) && v.name.equals("O")) {
					// System.out.println("deneme2: " + v.num);
					digraph.dfs(digraph, v, vertices);
				}
			}

		}

		for (Vertex v : vertices) {
			if (v.name.equals("O") && !digraph.markedVertices.contains(v)) {
				v.setName("X");
			}

		}

		int a = 0;
		for (Vertex v : vertices) {
			System.out.print(v.name + " ");
			a++;
			if (a == column) {
				System.out.println();
				a = 0;
			}

		}

	}
	
	public static void DigraphHelper(Digraph digraph, String[] lines, int column) {
		/*
		 * 
		 * this class connects the edges properly so we can render the digraph correctly
		 */

		for (int i = 0; i < lines.length - 1; i++) {

			String[] firstLine = new String[column];
			String[] secondLine = new String[column];
			firstLine = lines[i].split(" ");
			// System.out.println("chars1 length:" + chars1.length);
			// System.out.println("chars2 :" + chars2.toString());
			secondLine = lines[i + 1].split(" ");
			// System.out.println("chars1 length: " + chars1.length);

			for (int a = 0; a < firstLine.length; a++) {

				if (firstLine[a].equals("O") && a != 0) {
					// System.out.println("deneme2");
					digraph.addEdge(vertices.get(i * column + a), vertices.get(i * column + a - 1));
				}

				if (secondLine[a].equals("O")) {
					// System.out.println("deneme3");
					digraph.addEdge(vertices.get((i + 1) * column + a), vertices.get(i * column + a));
				}
			}

			for (int a = 0; a < firstLine.length; a++) {
				// System.out.println("deneme1");
				if (a != firstLine.length - 1) {
					digraph.addEdge(vertices.get(i * column + a), vertices.get(i * column + a + 1));
				}

				digraph.addEdge(vertices.get(i * column + a), vertices.get((i + 1) * column + a));

			}

		}

		String[] charsLast = lines[lines.length - 1].split(" ");
		for (int a = 0; a < charsLast.length; a++) {
			if (charsLast[a].equals("O") && a != 0) {
				// System.out.println("deneme2");
				digraph.addEdge(vertices.get((lines.length - 1) * column + a),
						vertices.get((lines.length - 1) * column + a - 1));
			}
		}

	}

}
