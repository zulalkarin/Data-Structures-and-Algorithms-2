package Part2;
//-----------------------------------------------------
//Title: Driver Class
//Author: Zulal Karin
//ID: 12622989076
//Section: 2
//Assignment: 2
//Description: This class creates an directed graph from input matrix and run dfs for particular vertices
//-----------------------------------------------------

import java.util.Scanner;

/* 
4
4
S S S S
S O S S
S O S O
S S S O
*/
public class Driver {

	public static void createEdges(String[] lines, Digraph digraph, int column) {
		/*
		 * this method takes input information from main and create digraph by using
		 * these informations and Digraph class
		 */
		for (int i = 0; i < lines.length; i++) {
			String[] chars1 = new String[column]; // S's and O's in a line
			chars1 = lines[i].split(" ");
			String[] chars2 = new String[column];
			chars2 = lines[i + 1].split(" ");

			for (int a = 0; a < chars1.length - 1; a++) {
				digraph.addEdge(chars1[a], chars1[a + 1]); // add edge between vertices in the same row
				digraph.addEdge(chars1[a], chars2[a]); // add edge between vertices in the same column
				if (chars1[a + 1].equals("O")) {
					digraph.addEdge(chars1[a + 1], chars1[a]);
				}
				if (chars2[a].equals("O")) {
					digraph.addEdge(chars2[a], chars1[a - 1]);
				}
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		int row = keyboard.nextInt(); // number of rows
		int column = keyboard.nextInt(); // number of columns
		String[] lines = new String[row]; // values in a row

		Digraph digraph = new Digraph();

		for (int i = 0; i < row; i++) {
			String rows = keyboard.nextLine(); // S S S S
			lines[i] = rows;

			// System.out.println("row: " + rows);
			// System.out.println("row length: " + rows.length());

		}

		createEdges(lines, digraph, column);
		
		
		/*for (int i = 0; i < lines.length; i++) {
			String[] chars = new String[column]; // S's and O's in a line
			chars = lines[i].split(" ");
			
			if(chars[0].equals("O")) 
				DFS dfs = new DFS(digraph, chars[0], chars);
			
				
			else if(chars[chars.length-1].equals("O")) 
				DFS dfs = new DFS(digraph, chars[chars.length-1], chars);
		
		
		}*/

	}

}
