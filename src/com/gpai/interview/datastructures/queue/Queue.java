package com.gpai.interview.datastructures.queue;

public class Queue {
	Node first;
	Node last;
	
	public void enqueue(int val) {
		Node node = new Node(val);	
		if (first == null) {
			first = node;
			last = node;
		} 
		else {
			last.next = node;
			last = node;
		}
	}
	
	public Node dequeue() {
		if (first == null) {
			return null;
		} else if (first == last) {
			Node node = first;
			first = null;
			last = null;
			return node;
		} else {
			Node node = first;
			first = first.next;
			return node;
		}
		
	}
	
	public void display() {
		if (first == null) {
			System.out.println("Empty");
		}
		
		Node node = first;
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
		
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.display();
		Node node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		
		// repeat
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		node = queue.dequeue();
		System.out.println(node);
		queue.display();
		
	}

}
