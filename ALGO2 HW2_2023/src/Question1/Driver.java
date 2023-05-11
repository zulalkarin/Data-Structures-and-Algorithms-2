package Question1;
//-------------------------------------------------------------------------
//Title: Driver Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 2 
//Question: 1
//Description: this class gets inputs and call other classes. 
//----------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {

	public static ArrayList<Integer> output = new ArrayList<>();

	public String toString() {
		return "output order=" + output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList<String> courses = new ArrayList<>();

		int num = scan.nextInt(); // first line of input (course num)
		String str = scan.next(); // second line of input (all courses)
		int lines = scan.nextInt(); // third line (number of prerequisite courses)

		Digraph digraph = new Digraph(); // I crated a graph object
		String[] course = str.split(","); // I seperated each course by using split function
		int length = course.length; // how many course are there?

		for (int i = 0; i < length; i++) {
			// I added vertices to the digraph I created
			digraph.addVertex(course[i]);
			courses.add(course[i]);
		}

		String preqCourse;
		String secondCourse;
		String[] prereqs;

		for (int i = 0; i < lines; i++) {
			// I created this loop for adding edges to the graph
			String prereq = scan.next();
			prereqs = prereq.split("-");
			preqCourse = prereqs[0];
			secondCourse = prereqs[1];
			digraph.addEdge(preqCourse, secondCourse);
		}

		String myCourse = scan.next();

		Topological topological = new Topological(digraph, myCourse, courses);
		// System.out.println("Topologica Order: " + topological.orderList());
		

		ArrayList<String> orderList = topological.orderList();
		int size = orderList.size();
		int index = orderList.indexOf(myCourse);

		if (index == size - 1) {
			System.out.println("There is no prerequisite for this course! ");
		} else {
			for (int i = index; i < size - 1; i++) {
				String str1 = orderList.get(i + 1);
				DepthFirstDirectedPaths paths = new DepthFirstDirectedPaths(digraph, str1, courses);
				if (paths.hasPathTo(myCourse, courses)) {
                    int intA = Integer.parseInt(orderList.get(i + 1));
					output.add(intA);

				}

			}

		}

		if (output.isEmpty()) {
			System.out.println("There is no prerequisite for this course! ");
		} else {
			Collections.sort(output);
			System.out.println(output.toString());
		}

	}


}

