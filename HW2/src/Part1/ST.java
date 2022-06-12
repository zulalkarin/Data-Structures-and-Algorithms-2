package Part1;

//-----------------------------------------------------

//Title: ST Class
//Author: Zülal Karýn
//ID: 12622989076
//Section: 2
//Assignment: 2
//Description: Sorted symbol table implementation
//-----------------------------------------------------

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {

	private TreeMap<Key, Value> st;

	public ST() { // Initializes an empty symbol table.
		st = new TreeMap<Key, Value>();
	}

	public Value get(Key key) { // Returns the value associated with the given key in this symbol table.
		if (key == null)
			throw new IllegalArgumentException("called get() with null key");
		return st.get(key);
	}

	public void put(Key key, Value val) { // Inserts the specified key-value pair into the symbol table
		if (key == null)
			throw new IllegalArgumentException("called put() with null key");
		if (val == null)
			st.remove(key);
		else
			st.put(key, val);
	}

	public void delete(Key key) { // Removes the specified key and its associated value from this symbol table
		if (key == null)
			throw new IllegalArgumentException("called delete() with null key");
		st.remove(key);
	}

	public void remove(Key key) { // Removes the specified key and its associated value from this symbol table
		if (key == null)
			throw new IllegalArgumentException("called remove() with null key");
		st.remove(key);
	}

	public boolean contains(Key key) { // eturns true if this symbol table contain the given key.
		if (key == null)
			throw new IllegalArgumentException("called contains() with null key");
		return st.containsKey(key);
	}

	public int size() { // Returns the number of key-value pairs in this symbol table.
		return st.size();
	}

	public boolean isEmpty() { // Returns true if this symbol table is empty.
		return size() == 0;
	}

	public Iterable<Key> keys() { // Returns all keys in this symbol table.
		return st.keySet();
	}

	public Iterator<Key> iterator() { // Returns all of the keys in this symbol table.
		return st.keySet().iterator();
	}

	public Key min() { // Returns the smallest key in this symbol table.
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return st.firstKey();
	}

	public Key max() { // Returns the largest key in this symbol table.
		if (isEmpty())
			throw new NoSuchElementException("called max() with empty symbol table");
		return st.lastKey();
	}

}
