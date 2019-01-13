package com.gpai.interview.datastructures.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Insertion, search, and deletion can all be done in O(log n) time.
 * Traversal is O(n)
 * 
 * @author gpai
 * 
 */
public class BinarySearchTree {

    private Node root;
    
    public BinarySearchTree(Node root) {
    	this.root = root;
    }

    // insert is split into two
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            insert(root, val);
        }
    }

    // this uses recursion
    public void insert(Node currentNode, int val) {
        
    	Node insertNode = new Node(val);

        if (val < currentNode.value) {
            if (currentNode.left == null) {
                currentNode.left = insertNode;
            } else {
                insert(currentNode.left, val);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = insertNode;
            } else {
                insert(currentNode.right, val);
            }
        }

    }

    // just a convenience function so you dont have to pass root
    public boolean contains(int val) {
        return contains(root, val);
    }

    // uses recursion
    public boolean contains(Node currentNode, int val) {
        if (currentNode != null) {
            if (val == currentNode.value) {
                return true;
            } else if (val < currentNode.value) {
                return contains(currentNode.left, val);
            } else {
                return contains(currentNode.right, val);
            }
        }
        return false;
    }

    // just a convenience function
    public Node findNode(int val) {
        return findNode(root, val);
    }

    //uses recursion; pretty much same as contains method
    public Node findNode(Node currentNode, int val) {
        if (currentNode != null) {
            if (val == currentNode.value) {
                return currentNode;
            } else if (val < currentNode.value) {
                return findNode(currentNode.left, val);
            } else {
                return findNode(currentNode.right, val);
            }
        }
        return null;

    }

    // just a convenience function
    public Node findParent(int val) {
        if (val == root.value || root == null) {
            return null;
        } else {
            return findNode(root, val);
        }
    }

    public Node findParent(Node currentNode, int val) {
        if (val < currentNode.value) {
            if (currentNode.left == null) {
                return null;
            } else if (currentNode.left.value == val) {
                return currentNode;
            } else {
                return findParent(currentNode.left, val);
            }
        } else {
            if (currentNode.right == null) {
                return null;
            } else if (currentNode.right.value == val)
                return currentNode;
            else {
                return findParent(currentNode.right, val);
            }
        }
    }

    // uses findParent and findNode functions; 
    // complicated enough that they almost never ask this in an interview
    public boolean delete(int val) {
        Node nodeToDelete = findNode(val);
        if (nodeToDelete == null) {
            return false;
        }
        Node parentNode = findParent(val);
        if (nodeToDelete == root) {
            root = null;
            return true;
        } else if (nodeToDelete.left == null && nodeToDelete.right == null) {
            if (nodeToDelete.value < parentNode.value) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
            return true;
        } else if (nodeToDelete.left == null && nodeToDelete.right != null) {
            if (nodeToDelete.value < parentNode.value) {
                parentNode.left = nodeToDelete.right;
            } else {
                parentNode.right = nodeToDelete.right;
            }
            return true;
        } else if (nodeToDelete.left != null && nodeToDelete.right == null) {
            if (nodeToDelete.value < parentNode.value) {
                parentNode.left = nodeToDelete.left;
            } else {
                parentNode.right = nodeToDelete.left;
            }
            return true;
        } else {
            // The value to remove has both a left and right subtree in which case we promote the largest value in the left subtree.
            Node largestValNode = nodeToDelete.left;
            while (largestValNode.right != null) {
                // Find the largest value in the left subtree of nodeToRemove
                largestValNode = largestValNode.right;
            }
            Node parentofLargestValNode = findParent(largestValNode.value);
            // set the parents' Right pointer of largestValue to null;
            parentofLargestValNode.right = null;
            nodeToDelete.value = largestValNode.value;
            return true;

        }

    }

    public int findMin() {
        if (root == null) {
            return -1;
        }
        Node currentNode = root;
        Node prev = null;
        while (currentNode != null) {
            prev = currentNode;
            currentNode = currentNode.left;
        }
        return prev.value;
    }

    public int findMax() {
        if (root == null) {
            return -1;
        }
        Node currentNode = root;
        Node prev = null;
        while (currentNode != null) {
            prev = currentNode;
            currentNode = currentNode.right;
        }
        return prev.value;
    }

    // just a convenience function
    public void preorderTraverse() {
        preorderTraverse(root);
    }

    // Pre-order traversal while duplicating nodes and edges 
    // can make a complete duplicate of a binary tree!
    public void preorderTraverse(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode = node;
        System.out.println(currentNode.value);
        preorderTraverse(currentNode.left);
        preorderTraverse(currentNode.right);
    }

    // just a convenience function
    public void postorderTraverse() {
        postorderTraverse(root);
    }

    // if you want to delete a tree, while by visiting and freeing the nodes, 
    // then post order is what you want to use!
    public void postorderTraverse(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode = node;
        postorderTraverse(currentNode.left);
        postorderTraverse(currentNode.right);
        System.out.println(currentNode.value);

    }

    // just a convenience function
    public void inorderTraverse() {
        inorderTraverse(root);
    }

    // This give the elements in ascending order !
    public void inorderTraverse(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode = node;
        inorderTraverse(currentNode.left);
        System.out.println(currentNode.value);
        inorderTraverse(currentNode.right);

    }




    
    // iterative inorder traversal
    public void traverseTreeInOrder(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stackedNodes = new Stack<Node>();
        while (!stackedNodes.isEmpty()) {
            if (node != null) {
                stackedNodes.push(node);
                node = node.left;
            } else {
                node = stackedNodes.pop();
                System.out.println("Node value: " + node.value);
                node = node.right;
            }
        }
    }
    
    public void breadthFirstUsingQueue() {
        breadthFirstUsingQueue(root);
    }
    
    public void breadthFirstUsingQueue(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        Node currentNode = root;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if (!queue.isEmpty()) {
                currentNode = queue.remove();
            } else {
                currentNode = null;
            }
        }
    }
    
    
    // Can be used to print the Tree; in breadth-first order. 
    // Even null nodes are printed and level is indicated.
    public void breadthFirstPrint() {
    	ArrayList<Node> nodes = new ArrayList<Node>();
    	nodes.add(root);
    	int level = 0;
    	boolean notAllNodesEmpty = true;
    	while(notAllNodesEmpty) {
    		notAllNodesEmpty = false;
    		System.out.println("-------------"
    				+ "Level:" + level);
    		for(int i=0; i< nodes.size(); i++) {
    			Node node =  nodes.get(i);
    			if (node!=null) {
    				notAllNodesEmpty = true;
    				System.out.println(node.value);
    			} else {
    				System.out.println("nullNode");
    			}
    		}
    		
    		nodes = getChildren(nodes);
    		level++;
    	}
    }
    
    // Just a convenience function for the above method - breadthFirstPrint()
    // Give a list of nodes, returns the children of all the nodes. 
    // Even null children are returned
    public ArrayList<Node> getChildren(ArrayList<Node> nodes) {
    	ArrayList<Node> children = new ArrayList<Node>();
    	for(int i=0; i< nodes.size(); i++) {
    		Node node =  nodes.get(i);
    		if(node!=null) {
    			Node nodeLeft = nodes.get(i).left;
    			Node nodeRight = nodes.get(i).right;
    			children.add(nodeLeft);
    			children.add(nodeRight);
    		}
    	}
    	return children;
    }
    
    /**
     * Given the root node a tree, return a set of all paths that add up to the targetSum
     * Doesn't assume this is a binary SEARCH tree. Works for both binary search tree and binary tree.
     * @param node Root of the tree (or could be any node really, from where you want to begin)
     * @param targetSum Targeted sum
     * @return Set of strings indicating all paths that add up to the targetSum
     */
    public  HashSet<String> findPathsWithSum(Node node, int targetSum) {
    	String currentPath = String.valueOf(node.value);
    	return progressTowardsSum(node, currentPath, new HashSet<String>(), node.value, targetSum );
    }
    
    
    /**
     * Used by findPathsWithSum
     * @param currentNode Node we are processing
     * @param currentPath Path of nodes we have taken so far, including the currentNode
     * @param allPaths All paths gathered so far, that sum to the targetSum
     * @param currentSum current sum so far of all the nodes in the currentPath, including the currentNode
     * @param targetSum The target sum for which we are finding all the paths
     * @return Set of strings that indicate the path that add up to the targetSum
     */
    public HashSet<String> progressTowardsSum(Node currentNode, String currentPath, HashSet<String> allPaths, int currentSum, int targetSum) {
    	
    	if(currentNode.left!=null) {
    		Node childNode = currentNode.left;
	    	int sum = currentSum + childNode.value;
	    	if(sum == targetSum) {
	    		String newCurrentPath = currentPath + "->" + childNode.value;
	    		allPaths.add(newCurrentPath);
	    	} else if (sum < targetSum) {
	    		String newCurrentPath = currentPath + "->" + childNode.value;
	    		progressTowardsSum(childNode, newCurrentPath, allPaths, sum, targetSum);
	    	} else if (sum > targetSum) {
	    		// do nothing
	    	}
    	} 
    	
    	if(currentNode.right!=null) {
    		Node childNode = currentNode.right;
	    	int sum = currentSum + childNode.value;
	    	if(sum == targetSum) {
	    		String newCurrentPath = currentPath + "->" + childNode.value;
	    		allPaths.add(newCurrentPath);
	    	} else if (sum < targetSum) {
	    		String newCurrentPath = currentPath + "->" + childNode.value;
	    		progressTowardsSum(childNode, newCurrentPath, allPaths, sum, targetSum);
	    	} else if (sum > targetSum) {
	    		// do nothing
	    	}
    	} 
    	
		return allPaths;
    	
    	

    }
    

    
    
    public static void main(String args[]) {
    	BinarySearchTree bst = new BinarySearchTree(null);
    	bst.insert(10);
    	bst.insert(55);
    	bst.insert(60);
    	bst.insert(65);
    	bst.insert(100);
    	bst.insert(95);
    	bst.insert(90);
    	bst.insert(70);
    	bst.insert(75);
    	bst.insert(15);
    	System.out.println("--------Breath First using queue:");
    	bst.breadthFirstUsingQueue();
    	System.out.println("--------Breath First using ArrayList:");
    	bst.breadthFirstPrint();
    	
    	// testing finding paths with nodes from root, that add up to a sum
    	Node root = new Node(10);
    	BinarySearchTree bst1 = new BinarySearchTree(root);
    	Node nodeLeft = new Node(20);
    	Node nodeRight = new Node(25);
    	root.left = nodeLeft;
    	root.right = nodeRight;
    	Node nodeLeft1 = new Node(10);
    	Node nodeRight1 = new Node(5);
    	nodeLeft.left = nodeLeft1;
    	nodeLeft.right = nodeRight1;
    	Node nodeLeft2 = new Node(5);
    	Node nodeRight2 = new Node(10);
    	nodeRight.left = nodeLeft2;
    	nodeRight.right = nodeRight2;
    	bst1.breadthFirstPrint();
    	System.out.println("---------Paths with the sum 40:");
    	System.out.println(bst1.findPathsWithSum(root, 40));
    	
    	
    	
    	
    	
    }

}
