package com.npai.interview.datastructures.trie;

public class Trie {
	
	private Node root;
	
	public Trie() {
		this.root = new Node(' ', false);
	}
	
	
	public void insert(String word) {
		
		if (word==null || word.isEmpty()) {
			return;
		}
		
		char[] letters = word.toCharArray();
		
		Node currentNode = root;
		// a is 97 in ASCII
		int offset = 97;
		
		for(int i=0; i < letters.length; i++) {
			Node[] childNodes = currentNode.children;
			if(childNodes[letters[i]-offset] == null) {
				boolean fullWord = (i == letters.length - 1);
				childNodes[letters[i]-offset] = new Node(letters[i], fullWord);
			}
			currentNode  = childNodes[letters[i]-offset];
		}
		
	}
	
	public boolean find(String word) {
		
		if (word==null || word.isEmpty()) {
			return false;
		}
		
		char[] letters = word.toCharArray();
		
		Node currentNode = root;
		// a is 97 in ASCII
		int offset = 97;
		
		for(int i=0; i < letters.length; i++) {
			Node[] childNodes = currentNode.children;
			if(childNodes[letters[i]-offset] == null) {
				return false;
			}
			currentNode  = childNodes[letters[i]-offset];
		}
		
		return currentNode.fullWord;
		
	}
	
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		
		trie.insert("dog");
		trie.insert("cat");
		
		System.out.println(trie.find("dog"));
		System.out.println(trie.find("cat"));
		System.out.println(trie.find("do"));
		System.out.println(trie.find("ca"));
		System.out.println(trie.find("donkey"));
		
		
	}
	

}
