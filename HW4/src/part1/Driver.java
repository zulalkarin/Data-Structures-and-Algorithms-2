package part1;

import java.util.Scanner;

/******************************************
* Title : Main class
* Author : Ahmet Berkay SARIASLAN - Zülal KARIN
* ID : 54490639066 - 12622989076
* Section : 02
* Assignment - 4
* Description : driver class that get the input from user and create trie. 
******************************************************/

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		TrieST trie = new TrieST();
		String nums = keyboard.next();
		int num = Integer.parseInt(nums);
		

		for (int i = 0; i < num; i++) {
			String word = keyboard.next();
			trie.put(word, 1);
		
			
		}
		
		String ArgumentNumber = keyboard.next();
		
		

	}

}
