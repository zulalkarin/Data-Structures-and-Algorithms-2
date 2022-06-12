package part2;
/******************************************
* Title : Main class
* Author : Ahmet Berkay SARIASLAN - Zülal KARIN
* ID : 54490639066 - 12622989076
* Section : 02
* Assignment - 4
* Description : driver class that get the input from user and create trie. 
* I'm getting the inputs from the user here. 
* Sources :
* 1-)Algorithms 4th Edition(our book)
* 2-)www.geeksforgeeks.com(Trie)
******************************************************/
import java.util.Scanner;

public class Driver {

	// Driver program to test above function
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		Trie trie = new Trie();
		String nums = keyboard.next();
		int num = Integer.parseInt(nums);
		String[] arr = new String[num];

		for (int i = 0; i < num; i++) {
			String word = keyboard.next();
			arr[i] = word;

			// trie.insert(word, 1);
		}

		// int n = arr.length;
		String ans = trie.findCommon(arr, num);
		// String ans = trie.walkTrie();

		// System.out.println("words: " + trie.keysThatMatch(ans));
		int numm = trie.number + 2;

		if (ans.length() != 0) {
			System.out.println("Longest common prefix: " + ans);
			System.out.println("Number of strings: " + numm);

		}

		else
			System.out.println("There is no common prefix");
	}
}
// This code is contributed by Sumit Ghosh
