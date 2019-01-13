package com.gpai.interview.miscellaneous;

import java.util.ArrayList;

// Problem: Given a set, generate all subsets
//{}
//{}, a
//{}, a , b, ab
//It is like adding the additional element in to the subsets of the smaller set. For, example, throwing 'c' in to the above subsets:
//{}, a, b, ab, c, ac, bc, abc

public class GenerateSubsets {
	
	public ArrayList<String> generate(ArrayList<String> set) {
		ArrayList<String> subsets = new ArrayList<String>();
		
		if(set.size() == 1) {
		  subsets.add("");
		  subsets.add(set.get(0));
		} else {
			// Let us say you are generating subsets of abc then this will get subsets of ab
			ArrayList<String> arList = generate(new ArrayList<String>(set.subList(0, set.size()-1)));
			ArrayList<String> arList1 = new ArrayList<String>();
			for(int i=0; i<arList.size(); i++) {
				// Generate new subsets, by taking the these subsets and throwing in the additional element (eg. c)
				// This will get you: c, ac, bc, abc
				arList1.add(arList.get(i) + set.get(set.size()-1));
			}
			// combine {}, a, b, ab with c, ac, bc, abc
			arList.addAll(arList1);
			subsets = arList;
		}
		
		return subsets;
	}
	
	public static void main(String[] args) {
		GenerateSubsets gsubset = new GenerateSubsets();
		ArrayList arList = new ArrayList();
		arList.add("a");
		arList.add("b");
		arList.add("c");
		System.out.println(gsubset.generate(arList));
		
		
	}

}
