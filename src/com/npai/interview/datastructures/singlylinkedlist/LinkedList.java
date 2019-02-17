package com.npai.interview.datastructures.singlylinkedlist;

/**
 * As such, linked lists in DSA have the following characteristics:
 * 
 * Insertion at end is O(1)
 * 
 * Insertion in middle is O(n)
 * 
 * Traversal is O(n)
 * 
 * Deletion is O(n)
 * 
 * Searching is O(n)
 * 
 * @author npai
 * 
 */
public class LinkedList {

    private Node head;

    private Node tail;

    public LinkedList() {

    }

    public Node append(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return node;
    }

    public boolean search(int val) {
        if (head == null) {
            return false;
        }

        Node node = this.head;
        while (node != null) {
            if (node.value == val) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void delete(int val) {
        Node node = this.head;
        Node prev = null;
        while (node != null) {
            if (node.value == val) {
                if (prev != null) {
                    prev.next = node.next;
                    return;
                } else {
                    head = node.next;
                    return;
                }
            }
            prev = node;
            node = node.next;
        }
    }

    public void insert(int val, int pos) {
        Node node = head;
        Node prev = null;
        int count = 0;
        Node newNode = new Node(val);
        while (node != null) {
            if (count == pos) {
                if (prev != null) {
                    prev.next = newNode;
                } else {
                    head = newNode;
                }
                newNode.next = node;
                return;
            }
            count++;
            prev = node;
            node = node.next;
        }

        // check if the position to be inserted was at the end, in which case node is null by now
        if (count == pos) {
            prev.next = newNode;
            tail = newNode;
        } else {
            System.out.println("Invalid pos");
        }
    }

    public boolean traverse() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        return false;
    }

    public void traverseInReverse() {
        Node node = tail;
        while (node != head) {
            System.out.println(node.value);
            Node prevNode = head;
            while (prevNode.next != node) {
                prevNode = prevNode.next;
            }
            node = prevNode;
        }
        System.out.println(node.value);
    }
    
    public void reverse() {
    	
    	Node firstNode = this.head;
    	Node secondNode = this.head.next;
    	
    	Node currentNode = firstNode;
    	Node prevNode = null;
    	Node nextNode = secondNode;
    	
    	while(currentNode!=null) {
    		
    		currentNode.next = prevNode;
    		
    		prevNode = currentNode;
    		currentNode = nextNode;
    		if(nextNode!=null) {
    			nextNode = nextNode.next;
    		}

    	}
    	
    	this.head = prevNode;
    	
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.traverse();
        System.out.println("----------");

        System.out.println(linkedList.search(1));
        System.out.println("----------");

        linkedList.delete(2);
        linkedList.traverse();
        System.out.println("----------");

        linkedList.insert(0, 0);
        linkedList.insert(2, 2);
        linkedList.insert(4, 4);
        linkedList.insert(6, 6);
        linkedList.traverse();
        System.out.println("----------");

        linkedList.traverseInReverse();
        System.out.println("----------");
        
        

        linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.reverse();
        linkedList.traverse();
        System.out.println("----b-----");
        

    }

}
