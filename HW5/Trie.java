/**
* Title : Trie class
* Author : Ahmet Berkay SARIASLAN - Zülal KARIN
* ID : 54490639066 - 12622989076
* Section : 02
* Assignment - 5
* Description : This class of crates an R-way trie  
**/



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trie {

	static final int R = 256;
	static Node root;
	static int N;

	int number;

	public static class Node { 
		Node[] next = new Node[R];

		boolean leaf;

		public Node() {
			leaf = false;
			for (int i = 0; i < R; i++)
				next[i] = null;
		}
	};

	public void put(String key) {
		Node first = root;
		int index;

		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';
			if (first.next[index] == null)
				first.next[index] = new Node();

			first = first.next[index];

		}

		//first.leaf = true;
	}

	private Node put(Node x, String key, int d) {
		if (x == null) {
			x = new Node();
			// x.isLeaf= true;
		}

		if (d == key.length()) {

			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, d + 1);
		// x.next[c].isLeaf= true;

		return x;
	}

	public Iterable<String> isMatch(String pattern) {
		// Queue<String> results = new Queue<String>();
		Queue<String> results = new LinkedList<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
		if (x == null)
			return;
		int d = prefix.length();
		if (d == pattern.length())
			results.add(prefix.toString());
		// results.enqueue(prefix.toString());
		if (d == pattern.length())
			return;
		char c = pattern.charAt(d);
		if (c == '.') {
			for (char ch = 0; ch < R; ch++) {
				prefix.append(ch);
				collect(x.next[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			prefix.append(c);
			collect(x.next[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	static int childNum(Node node) {
		int count = 0;
		for (int i = 0; i < R; i++) {
			if (node.next[i] != null) {
				count++;
				N = i;
			}
		}
		return (count);
	}



	public void create(String arr[], int n) {
		for (int i = 0; i < n; i++)
			put(arr[i]);
		return;
	}


}