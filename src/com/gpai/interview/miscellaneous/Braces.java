package com.gpai.interview.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Braces {
	
	
    public static void check_braces(String[] expressions) {
    	ArrayList results = new ArrayList();
    	
    	for(int i=0; i<expressions.length; i++) {
    		if(matchedBraces(expressions[i])) {
    			results.add(1);
    		} else {
    			results.add(0);
    		}
    	}
    	
    	for(int i=0; i<results.size(); i++) {
    		System.out.println(results.get(i));
    	}
    	
        
    }
    
    
    public static boolean matchedBraces(String str) {
    	char[] chars = str.toCharArray();
    	
    	
    	HashMap openingBracesCount = new HashMap();
    	HashMap closingBracesCount = new HashMap();
    	for(int i=0; i<chars.length; i++) {
    		if (chars[i]=='{' || chars[i]=='(' || chars[i]=='[') {
    			Integer count = (Integer)openingBracesCount.get(String.valueOf(chars[i]));
    			if(count!=null) {
    				openingBracesCount.put(String.valueOf(chars[i]), Integer.valueOf(count.intValue()+1));
    			} else {
    				openingBracesCount.put(String.valueOf(chars[i]), Integer.valueOf(1));
    			}
    		}
    		
			if(i==chars.length-1) {
				return false;
			}
    		
    		if (chars[i]=='}' || chars[i]==')' || chars[i]==']') {
    			if(i==0) {
    				return false;
    			}
    			Integer count = (Integer)closingBracesCount.get(String.valueOf(chars[i]));
    			if(count!=null) {
    				closingBracesCount.put(String.valueOf(chars[i]), Integer.valueOf(count.intValue()+1));
    			} else {
    				closingBracesCount.put(String.valueOf(chars[i]), Integer.valueOf(1));
    			}
    			
    			if((chars[i]==')' && chars[i-1]=='(') || (chars[i]==']' && chars[i-1]=='[') || (chars[i]=='}' && chars[i-1]=='{')) {
    				continue;
    			} else {
    	            if(openingBracesCount.keySet().size()==closingBracesCount.keySet().size()) {
    	            	Iterator iter = openingBracesCount.keySet().iterator();
    	            	while(iter.hasNext()) {
    	            		String key = (String)iter.next();
    	            		String key1 = null;
    	            		if(key.equals("[")) {
    	            			key1 = "]";
    	            		} else if (key.equals("(")) {
    	            			key1 = ")";
    	            		} else if (key.equals("{")) {
    	            			key1 = "}";
    	            		}
    	            		Integer count1 = (Integer)openingBracesCount.get(key);
    	            		Integer count2 = (Integer)closingBracesCount.get(key1);
    	            		if(count2!=null && count2.intValue()==count1.intValue()) {
    	            			continue;
    	            		} else {
    	            			return false;
    	            		}
    	            		
    	            	}
    	            } else {
    	            	return false;
    	            }
    				
    			}
    		}
    		

    		
    	}
    	
    	return true;
    }
    
    public static void main(String[] str) {
    	System.out.println(Braces.matchedBraces("[]({})"));
    	String[] arr = { ")(){}", "[]({})", "([])", "{()[]}", "([)]" };
    	Braces.check_braces(arr);
    }

}
