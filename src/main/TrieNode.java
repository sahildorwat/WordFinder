package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class TrieNode {
	private HashMap<Character, TrieNode> children;
    private ArrayList<String> list;
    private boolean isWord;
	
    TrieNode () {
    	children = new HashMap<>();
    	list = new ArrayList<>();
    	isWord = false;
    }
    
    public HashMap<Character, TrieNode> getChildren() {
    	return children;
    }
    
    public void setEndOfWord(boolean _isWord) {
    	isWord = _isWord;
    }
    
    public boolean getIsWord() {
    	return isWord;
    }
    
    public void setListOfEncodedStrings(String encodedSTringForFile ) {
    	list.add(encodedSTringForFile);
    }
    
    public List<String> getListOfEncodeFileString() {
    	return list;
    }
}
