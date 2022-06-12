package part1;

/******************************************
* Title : Trie class
* Author : Ahmet Berkay SARIASLAN - Z�lal KARIN
* ID : 54490639066 - 12622989076
* Section : 02
* Assignment - 4
* Description : This class of cretes an R-way trie
******************************************************/

import java.util.LinkedList;
import java.util.Queue;

public class TrieST<Value> {
	private static final int R = 2;

	private Node root; // root of trie
	private int n; // number of keys in trie

	// R-way trie node
	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}

	/**
	 * Initializes an empty string symbol table.
	 */
	public TrieST() {
	}

	public Value get(String key) {
		if (key == null)
			throw new IllegalArgumentException("argument to get() is null");
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	public boolean contains(String key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	public void put(String key, Value val) {
		if (key == null)
			throw new IllegalArgumentException("first argument to put() is null");
		if (val == null)
			delete(key);
		else
			root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			if (x.val == null)
				n++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> results = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, Queue<String> results) {
		if (x == null)
			return;
		if (x.val != null)
			results.add(prefix.toString());
		for (char c = 0; c < R; c++) {
			prefix.append(c);
			collect(x.next[c], prefix, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> results = new LinkedList<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, String pattern, Queue<String> results) {
		if (x == null)
			return;
		int d = prefix.length();
		if (d == pattern.length() && x.val != null)

			results.add(prefix.toString());
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

	public String longestPrefixOf(String query) {
		if (query == null)
			throw new IllegalArgumentException("argument to longestPrefixOf() is null");
		int length = longestPrefixOf(root, query, 0, -1);
		if (length == -1)
			return null;
		else
			return query.substring(0, length);
	}

	private int longestPrefixOf(Node x, String query, int d, int length) {
		if (x == null)
			return length;
		if (x.val != null)
			length = d;
		if (d == query.length())
			return length;
		char c = query.charAt(d);
		return longestPrefixOf(x.next[c], query, d + 1, length);
	}

	public void delete(String key) {
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");
		root = delete(root, key, 0);
	}

	private Node delete(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length()) {
			if (x.val != null)
				n--;
			x.val = null;
		} else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}

		// remove subtrie rooted at x if it is completely empty
		if (x.val != null)
			return x;
		for (int c = 0; c < R; c++)
			if (x.next[c] != null)
				return x;
		return null;
	}

}