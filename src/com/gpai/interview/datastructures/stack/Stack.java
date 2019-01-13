package com.gpai.interview.datastructures.stack;

import com.gpai.interview.datastructures.queue.Node;

public class Stack {
	
	Node top;
	
	public Node pop() {
		if (top == null) {
			return null;
		}
		
		Node node = top;
		top = top.next;
		return node;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		if (top == null) {
			top = node;
		} else {
			Node prevTop = top;
			top = node;
			top.next = prevTop;
		}
	}
	
	public void display() {
		if (top == null) {
			System.out.println("Empty");
		}
		
		Node node = top;
		while(node!=null) {
			System.out.print(node.value);
			if (node.next!=null) {
				System.out.print("->");	
			} else {
				System.out.println("");	
			}
				
			node = node.next;
		}
	}
	
	public static void main(String args[]) {
		Stack stack = new Stack();
		
		stack.push(10);
		stack.display();
		stack.push(20);
		stack.display();
		stack.push(30);
		stack.display();
		
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		
		//repeat
		stack.push(10);
		stack.display();
		stack.push(20);
		stack.display();
		stack.push(30);
		stack.display();
		
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		
		
	}

}
