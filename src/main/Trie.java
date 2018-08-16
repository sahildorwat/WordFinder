package main;

import java.util.List;

public class Trie {
	
	class Node {
		List<String> listOfMatchedEncodedString;
		boolean isWord;
		Node (List<String> listOfMatchedEncodedString, boolean isWord ) {
			this.listOfMatchedEncodedString = listOfMatchedEncodedString;
			this.isWord = isWord;
		}
	}
	public TrieNode root;
	
	Trie() {
		root = new TrieNode();
	}
	
   public void insert(String word, String encodedFileStringList) {
        TrieNode current = root;
     
        for (int i = 0; i < word.length(); i++) {
           char temp = word.charAt(i);
		   if( !current.getChildren().containsKey(temp)) {
			   current.getChildren().put(temp, new TrieNode());
		   } 
		   current = current.getChildren().get(temp);
        }
        current.setEndOfWord(true);
        if( encodedFileStringList != null)
        	current.setListOfEncodedStrings(encodedFileStringList);
    }
   
   public List<String> getCorrespondingLines(String word ){
	   Node dummyNode = isWordExists(word);
	   if( dummyNode.isWord) {
		   return dummyNode.listOfMatchedEncodedString;
	   }
	   return null;
   }
   
   public Node isWordExists(String word) {
	   int length = word.length();
	   TrieNode current = root;
	   for( int i = 0; i < length; i++ ) {
		   char temp = word.charAt(i);
		   if(!current.getChildren().containsKey(temp)) {
//			   System.out.println("returning false");
			   return new Node(null, false);
		   }
		   current = current.getChildren().get(temp);
	   }
	   if(current.getIsWord()) {
		   return new Node( current.getListOfEncodeFileString(), true);
	   }
//		   for(String s: current.getListOfEncodeFileString()) {
//			   System.out.println(s);   
//		   }
//	   }
	   return new Node (null, false); 
   }
   
//   public static void main(String[] args) {
//	   Trie t = new Trie();
//	   t.insert("sahil", "sahil is here");
//	   if(t.isWordExists("sahil"))
//		   System.out.println("word exits");
//	   else
//		   System.out.println("Word not exists");
//   }
}
