package com.gpai.interview.datastructures.trie;

public class Node {
	
	public char letter;
	public Node[] children;
	public boolean fullWord = false;
	
	public Node(char letter, boolean fullWord) {
        this.letter = letter;
        children = new Node[26];
        this.fullWord = fullWord;
    }
	
}
