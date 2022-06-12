/* Title : TST class
 * Author : Ahmet Berkay SARIASLAN - Zülal KARIN
 * ID : 54490639066 - 12622989076
 * Section : 02
 * Assignment - 5
 * Description : This class of Trie data structure class. 
 * Source :
 * 1-)www.geeksforgeeks.com
 * 2-)Algorithms 4th Edition(our book)
 */



public class TST<T extends Comparable<T>> {
	
	private char  character;
	private T value;
	private TST<T> leftChild;
	private TST<T> rightChild;
	private TST<T> middleChild;
	private TST<T> root;
	
	  //helper method
	
	public boolean isEndOfWord() {
		return value != null;
		 
	}
	public interface Tree<T extends Comparable<T>>{
		Tree<T> insert (String word, T value);
		boolean contains(String word);
		T get (String key);
		void softDelete(String word);
	}
	
	public void insert(String word, T value){
		root = insert(root,word,value,0);
		//return (TST.Tree<T>) this;
		
	}

	private TST<T> insert(TST<T> root2, String word, T value2, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	//insert and delete, we don't need this.

}
