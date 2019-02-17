package com.npai.interview.miscellaneous;

import java.util.ArrayList;

public class PermutationString {
	
	// Given a string and a mix, it returns a collection of strings with the mix inserted at
	// all possible positions. For example, for str ab and mix as c, it will give you:
	// cab, acb, abc. So c is inserted a beginning, middle and end of the string.
	public static ArrayList<String> mixin(String str, String mix) {
		ArrayList<String> arList = new ArrayList<String>();
		
		for(int k=0; k <str.length()+1; k++) {
			String mixin = str.substring(0, k) + mix + str.substring(k);
			arList.add(mixin);
		}
		
		return arList;
		
	}
	
	// recursive function to generate all permutations of a string. The recursion stems from
	// observing the following:
	// permutation of "a" is "a"
	// permutation of "ab" is ab, ba which is obtained by mixing in the additional character b
	// with permutations of "a"
	// And so on....
	public static ArrayList<String> permutate(String string, ArrayList<String> mixins) {
		if(string==null || string.length()==0) {
			return mixins;
		}
		
		ArrayList<String> grandMixins = new ArrayList<String>();
		if(mixins.isEmpty()) {
			grandMixins.add(string.substring(0,1));
		} else {
			for(int i=0; i < mixins.size(); i++) {
				grandMixins.addAll(mixin(mixins.get(i), string.substring(0, 1)));
			}
		}
		return permutate(string.substring(1), grandMixins);

	}
	
	// Just the entry level function
	public static void generate(String str) {
		ArrayList<String> permutations = permutate(str, new ArrayList<String>());
		for(int i=0; i < permutations.size(); i++) {
			System.out.println(permutations.get(i)+",");
		}
		
	}
	
	//Test!
	public static void main(String[] args) {
		
		System.out.println(PermutationString.mixin("ab", "c"));
		
		System.out.println("---PERMUTATIONS---");
	    PermutationString.generate("abc");
	    
		
	}

}
