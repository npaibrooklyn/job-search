package com.npai.interview.miscellaneous;

public class Fibonacci {
	
	//generate the nth fibonacci number
	public int generate(int n) {
		if(n==1) {
			return 1;
		} else if(n==2) {
			return 2;
		} else 
		return generate(n-1) + generate(n-2);
	}
	
	public void printNumbers(int n) {
		int a = 1;
		int b = 2;
		System.out.println(a);
		System.out.println(b);
		for(int i=0; i< n; i++) {
			int c = a + b; 
			System.out.println(c);
			a=b;
			b=c;
		}
		
		
	}
	
	
	public static void main(String[] str) {
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.generate(5));
		
		fib.printNumbers(10);
	}
}
