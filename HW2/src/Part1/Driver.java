package Part1;
//-----------------------------------------------------
// Title: Driver Class
// Author: Zülal Karýn
// ID: 12622989076
// Section: 2
// Assignment: 2
// Description: This class creates an directed graph and calls topological sort algorithm 
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Digraph digraph = new Digraph(); // create a digraph
		Scanner keyboard = new Scanner(System.in);
		int count = keyboard.nextInt(); // number of courses
		String courses = keyboard.next(); // 112,113,114,223,224,225,315 // courses
		String[] courseS = courses.split(",");
		ArrayList<String> coursesArr = new ArrayList<>();// I hold the courses in an arraylist because I will use it's
															// index numbers.

		for (int i = 0; i < courseS.length; i++) { // add all courses to the graph
			digraph.addVertex(courseS[i]);
			coursesArr.add(courseS[i]);
		}

		int prereqCount = keyboard.nextInt(); // number of prerequisite information

		for (int i = 0; i < prereqCount; i++) {
			String input = keyboard.next();
			String[] parts = input.split("-");
			String course1 = parts[0]; // priority course
			String course2 = parts[1]; // other course
			digraph.addEdge(course1, course2); // add directed edge between courses
		}

		String quest = keyboard.next(); // last input
		String[] parts = quest.split("-");
		String course1 = parts[0]; // first course
		String course2 = parts[1]; // second course

		// System.out.println("edges: " + digraph.E());
		// System.out.println("vertices:" + digraph.V());

		DirectedDFS dfs = new DirectedDFS(digraph, course1, coursesArr);
		int first = dfs.reversePostorder.indexOf(course1); // if cours's index is bigger, return true.
		int second = dfs.reversePostorder.indexOf(course2);

		if (first > second && dfs.marked(course2, coursesArr)) // I checked second course is reachable from first course
																// and it has less priority
			System.out.println("Answer: True");

		else
			System.out.println("Answer: False");

	}

}
