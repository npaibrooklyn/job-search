package com.gpai.interview.miscellaneous;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Anagram {
    public static void check_anagrams(String[] firstWords, String[] secondWords) {
    	ArrayList results = new ArrayList();
    	for (int i=0; i<firstWords.length; i++) {
    		if(isAnagram(firstWords[i], secondWords[i])) {
    			results.add(1);
    		} else {
    			results.add(0);
    		}
    	}
    	
    	for (int i=0; i<results.size(); i++) {
    		System.out.println(results.get(i));
    	}
    	
        
    
        
    }
    
    public static boolean isAnagram(String word1, String word2) {
        HashMap charCount1 = new HashMap();
        HashMap charCount2 = new HashMap();
        
        
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        
        for(int i=0; i<chars1.length; i++) {
        	
        	Integer charCount = (Integer)charCount1.get(String.valueOf(chars1[i]));
        	if (charCount!=null) {
        		charCount1.put(String.valueOf(chars1[i]), Integer.valueOf(charCount.intValue()+1));
        	} else {
        		charCount1.put(String.valueOf(chars1[i]), Integer.valueOf(1));
        	}
        }
        
        for(int i=0; i<chars2.length; i++) {
        	
        	Integer charCount = (Integer)charCount2.get(String.valueOf(chars2[i]));
        	if (charCount!=null) {
        		charCount2.put(String.valueOf(chars2[i]), Integer.valueOf(charCount.intValue()+1));
        	} else {
        		charCount2.put(String.valueOf(chars2[i]), Integer.valueOf(1));
        	}
        }
        
        if(charCount1.keySet().size()==charCount2.keySet().size()) {
        	Iterator iter = charCount1.keySet().iterator();
        	while(iter.hasNext()) {
        		String key = (String)iter.next();
        		Integer count1 = (Integer)charCount1.get(key);
        		Integer count2 = (Integer)charCount2.get(key);
        		if(count2!=null && count2.intValue()==count1.intValue()) {
        			continue;
        		} else {
        			return false;
        		}
        		
        	}
        } else {
        	return false;
        }
        
        return true;
        	
    }
    
    public static void main(String[] str) {
    	System.out.println(Anagram.isAnagram("aba", "bab"));
    	String[] array1 = {"cat", "dog", "gum"};
    	String[] array2 = {"tac", "dgo", "gmm"};
    	Anagram.check_anagrams(array1, array2);
    	
    }
    
}
