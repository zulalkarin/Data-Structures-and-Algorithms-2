/* Title : HashTable class
 * Author : Ahmet Berkay SARIASLAN - Zülal KARIN
 * ID : 54490639066 - 12622989076
 * Section : 02
 * Assignment - 5
 * Description : This class of HashMap data structure class. 
 * Source :
 * 1-)www.geeksforgeeks.com
 * 2-)Algorithms 4th Edition(our book)
 */


import java.awt.RenderingHints.Key;
//linear probing hashTable

public class HashTable {
	private int n; // number of key-value pairs in the table
	int initialSize = 16; // size of linear-probing table (M)
	private Key [] keys; // keep Key
	private long [] values; // keep values
	
	
	
	public HashTable() { //constructor
		int size  = 16 ; 
		
		//keys = (Key[]) new Object[initialSize]; // define object (key)
		values = (long[]) new long[initialSize]; // define object (value)
		
	}
	
	private int hash(Key key) {
		return(key.hashCode());
		// 0x7ffffffff % M
	}
	
	private void resize(int peak) { //Resizing hashtable when hashtable is full
		//LinearProbingHashST<keys, values> newSize = new LinearProbingHashST<keys,values>(capacity);
		
		HashTable v = new HashTable();
		for (int i = 0; i < initialSize; i++)
			if (keys[i] != null) {
				v.put(keys[i],values[i]);
				
			}
		keys = v.keys; // temp operation newSize of valeus
		values = v.values;
		initialSize  = v.initialSize;
				
}
	
	

	void put(Key key, long v) { //put operation
		// TODO Auto-generated method stub
		if(n>=initialSize/2) {
			resize(2*initialSize); //double size multiple to 2 
		}
		for(int i = hash(key); keys[i]!=null; i=(i+1)%initialSize) { //adding the specified key
			if(keys[i].equals(key)){
				values[i] = v ; 
				return ; 
				
			}
			keys[i] = key;
			values[i] = v ; 
			n++ ;
			
		}
		
	}
	public long get(Key key) { //get operation for value
		for(int i = hash(key); keys[i]!=null; i=(i+1)%initialSize) {
			if(keys[i].equals(key)){
			
				return values[i] ;
				
	}
}
		return 0;
	}
	public Key gett(Key key) {
		for(int i = hash(key); keys[i]!=null; i=(i+1)%initialSize) {
			if(keys[i].equals(key)){
			
				return keys[i] ;
		
	}
}
		return null;
	}

	@Override
	public String toString() {
		return "LinearProbingHashST [initialSize=" + initialSize + "]";
	}

	public void put(String word) {
		// TODO Auto-generated method stub
		
	}
	
}