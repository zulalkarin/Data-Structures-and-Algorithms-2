/* Title : Main class
 * Author : Ahmet Berkay SARIASLAN - Zülal KARIN
 * ID : 54490639066 - 12622989076
 * Section : 02
 * Assignment - 5
 * Description : This class of Test class. 
 * We're reading our input in here. We can write all output and we can test perfomance test in here. 
 * Also, we write our two base function. These are countWord and findWord.
 * Plus, we give some data structure iteration in here.
 * Source :
 * 1-)www.geeksforgeeks.com
 * 2-)Algorithms 4th Edition(our book)
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	//Binary Data Structure
	 private final BST bst = new BST();
	 private final TST tst = new TST();
	 private final HashTable ht = new HashTable();
	 
	 private final Trie trie = new Trie(); //R-TRÝE
	 
	    void FindWord(String arg){
	        String tree = bst.show();	        
	        String[] treeData = tree.split(" ");
	        for (String s : treeData){
	            if (s.indexOf(arg) == 0) 
	            	System.out.println(s + " ");
	        }
	    }
	    
	    void CountAll(){
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        String tree = bst.show();
	        String[] treeData = tree.split(" ");
	        for (String s : treeData){
	            s = s.toLowerCase();
	            if (map.containsKey(s)) map.put(s, map.get(s)+1);
	            else map.put(s, 1);
	        }
	        for (Map.Entry<String, Integer> entry : map.entrySet()){
	        	
	            System.out.println(entry.getKey() + ": "+ entry.getValue());
	        }
	    }
	    

	    public void firstInput() throws FileNotFoundException {
	        File file  = new File("C:\\Users\\Ahmet Berkay\\Desktop\\input1.txt");
	        Scanner key = new Scanner(file);
	        StringBuilder input = new StringBuilder();
	        while (key.hasNextLine()) {
	            input.append(" ").append(key.nextLine());
	        }
	        String[] data = input.toString().split(" ");
	        bst.root = null;
	        for (String s : data) {
	        	bst.insert(s);
	        	tst.insert(s,1);
	        	ht.put(s);
	        	//trie.put(s);
	        
	        }
	        
	    }

	    public void secondInput() throws FileNotFoundException {
	        File file  = new File("C:\\Users\\Ahmet Berkay\\Desktop\\input2.txt");
	        Scanner key = new Scanner(file);
	        StringBuilder input = new StringBuilder();
	        while (key.hasNextLine()) {
	            input.append(" ").append(key.nextLine());
	        }
	        String[] data = input.toString().split(" ");
	        bst.root = null;
	        for (String s : data) {
	        	bst.insert(s);
	        	tst.insert(s,1);
	        	ht.put(s);
	        	//trie.put(s);
	        
	        }
	        
	    }



	    public static void main(String[] args) throws FileNotFoundException{
	    	
	    	/*File file = new File("C:\\Users\\Ahmet Berkay\\Desktop\\input1.txt");
	    	Scanner scan = new Scanner(file);
	    	System.out.println(scan.nextLine());
	    	*/
	    	
	    	
	    	
	    	// we can use these strings for hash table
	    	String text = "lorem ipsum dolor sit amet consectetur adipiscing elit\r\n"
	    			+ "cras est eros pharetra vel vestibulum ut auctor in odio\r\n"
	    			+ "maecenas porta pellentesque leo eget vestibulum\r\n"
	    			+ "in vulputate volutpat nunc\r\n"
	    			+ "aliquam in gravida tortor eget suscipit erat\r\n"
	    			+ "maecenas id tristique velit non dictum dui\r\n"
	    			+ "fusce orci magna pellentesque hendrerit dui eget elementum dignissim nisl\r\n"
	    			+ "ut accumsan id erat id efficitur\r\n"
	    			+ "nullam vitae eros feugiat feugiat augue sed condimentum dui\r\n"
	    			+ "aliquam porttitor ipsum eget placerat sollicitudin\r\n"
	    			+ "aliquam erat volutpat Fusce vitae magna augue\r\n"
	    			+ "in auctor sit amet orci tempus vehicula\r\n"
	    			+ "nullam eu imperdiet justo\r\n"
	    			+ "nulla dui dui accumsan eu suscipit a placerat bibendum felis\r\n"
	    			+ "maecenas vitae quam vitae nisl feugiat lacinia\r\n"
	    			+ "vivamus tincidunt faucibus pretium\r\n"
	    			+ "quisque vel quam est\r\n"
	    			+ "vestibulum tempus aliquet diam ut egestas arcu vestibulum luctus\r\n"
	    			+ "cras non ornare elit quis tristique nunc\r\n"
	    			+ "nulla posuere sapien id lectus venenatis vitae mattis tortor maximus\r\n"
	    			+ "maecenas molestie placerat tempor\r\n"
	    			+ "donec luctus facilisis maximus\r\n"
	    			+ "vivamus quis felis lobortis luctus urna ac consectetur elit\r\n"
	    			+ "vivamus scelerisque dui eget massa tincidunt sed consequat mauris vulputate\r\n"
	    			+ "in ac pellentesque ante\r\n"
	    			+ "proin vel mattis ipsum\r\n"
	    			+ "donec rhoncus ex leo eu porta mauris blandit id\r\n"
	    			+ "aliquam blandit hendrerit nulla eu bibendum lorem vulputate nec\r\n"
	    			+ "praesent interdum urna sit amet leo convallis varius";
	    	
	    	
	    	// HASH TABLE 
	    	/*
	    	String [] words = key.nextLine().split("");
		LinearProbingHashST hash_ST = new LinearProbingHashST (capacity) ;
		//LinearProbingHashST<String,Integer> hashTable = new LinearProbingHashST<String,Integer>(capacity);
		int number;
		for(int i=0;i<words.length;i++) {
			number = 1 ;
			for(int j=i+1; j<words.length;j++) {
				if(words[i].equals(words[j]))
					number = number + 1;
					words[j]="0";
					

			}
		
		if(words[i] != "0"){
			System.out.println(words[i] + "           " +number);
			
		}
		}
		
		LinearProbingHashST hashTable = new LinearProbingHashST (capacity) ;
		for(String s : args)
			hashTable.put(word,capacity);
			
		int SeperateInd [];
		int LinearInd [];
		SeparateChainingHashST hashTable2 = new SeparateChainingHashST();
        for(String word: args)
            hashTable2.get(word);
	    	 */
	    	
	    	
	
	    	
	    	/*
	    	long start = System.currentTimeMillis();
	    	for(int i=0;i<array.length;i++){
	            testing.put(array[i], testing.get(array[i])+1);
	    	
	    	}
	    	long end = System.currentTimeMillis();
	    	long totalTime = end - start ;
	    	System.out.println("Time: "+totalTime);
	    	*/
	    	
	    	
	    	Main main = new Main();
	    	 StopWatch watch1 = new StopWatch();   //I created stopwatch object  
	         main.firstInput();
	         main.FindWord("con");
	         double time1 = watch1.elapsedTime();  //elapsedTime() is returns the elapsed time.
	         System.out.println("elapsedTime time:  " + time1 + " ms.");
	    	
	    	
	    			
	    	

	    }

}
