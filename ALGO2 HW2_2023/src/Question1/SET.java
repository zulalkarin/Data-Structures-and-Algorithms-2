package Question1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
	private TreeSet<Key> set;

	public SET() { // Initializes an empty set.
		set = new TreeSet<Key>();
	}

	public SET(SET<Key> x) { // Initializes a new set that is an independent copy of the specified set.
		set = new TreeSet<Key>(x.set);
	}

	public void add(Key key) {
		if (key == null)
			throw new IllegalArgumentException("called add() with a null key"); // Adds the key to this set (if it is
																				// not already present).
		set.add(key);
	}

	public boolean contains(Key key) { // Returns true if this set contains the given key.
		if (key == null)
			throw new IllegalArgumentException("called contains() with a null key");
		return set.contains(key);
	}

	public void delete(Key key) { // Removes the specified key from this set (if the set contains the specified
									// key).
		if (key == null)
			throw new IllegalArgumentException("called delete() with a null key");
		set.remove(key);
	}

	public int size() { // Returns the number of keys in this set.
		return set.size();
	}

	public boolean isEmpty() { // Returns true if this set is empty.
		return size() == 0;
	}

	public Iterator<Key> iterator() {
		return set.iterator();
	}

	public Key max() { // Returns the largest key in this set.
		if (isEmpty())
			throw new NoSuchElementException("called max() with empty set");
		return set.last();
	}

	public Key min() { // Returns the smallest key in this set.
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty set");
		return set.first();
	}

	public Key ceiling(Key key) { // Returns the smallest key in this set greater than or equal to {@code key}.
		if (key == null)
			throw new IllegalArgumentException("called ceiling() with a null key");
		Key k = set.ceiling(key);
		if (k == null)
			throw new NoSuchElementException("all keys are less than " + key);
		return k;
	}

	public Key floor(Key key) { // Returns the largest key in this set less than or equal to {@code key}.
		if (key == null)
			throw new IllegalArgumentException("called floor() with a null key");
		Key k = set.floor(key);
		if (k == null)
			throw new NoSuchElementException("all keys are greater than " + key);
		return k;
	}

	public SET<Key> union(SET<Key> that) { // Returns the union of this set and that set.
		if (that == null)
			throw new IllegalArgumentException("called union() with a null argument");
		SET<Key> c = new SET<Key>();
		for (Key x : this) {
			c.add(x);
		}
		for (Key x : that) {
			c.add(x);
		}
		return c;
	}

	public SET<Key> intersects(SET<Key> that) { // Returns the intersection of this set and that set.
		if (that == null)
			throw new IllegalArgumentException("called intersects() with a null argument");
		SET<Key> c = new SET<Key>();
		if (this.size() < that.size()) {
			for (Key x : this) {
				if (that.contains(x))
					c.add(x);
			}
		} else {
			for (Key x : that) {
				if (this.contains(x))
					c.add(x);
			}
		}
		return c;
	}

	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		SET that = (SET) other;
		return this.set.equals(that.set);
	}

	public int hashCode() {
		throw new UnsupportedOperationException("hashCode() is not supported because sets are mutable");
	}

	@Override
	public String toString() {
		String s = set.toString();
		return "{ " + s.substring(1, s.length() - 1) + " }";
	}

}
