package de.tuberlin.prog1.collections;

/**
 * Represents a Binary Tree Node
 */
public class Node<T extends Comparable<T>> {
    //left Tree
	private Node<T> left;
	//right Tree
	private Node<T> right;

	//payloadData
	private T data;
	
	public Node(T data) {
		this.data = data;
	}

    /**
     * Tests if this node is a Leaf (if it has no subtrees)
     * @return
     */
	public boolean isLeaf(){
		return left == null && right == null;
	}
	
	public T getData(){
		return data;
	}

    /**
     * Inserts a node into this subtree
     * @param node
     */
	public void insert(Node<T> node){
		//insert right
		if(this.data.compareTo(node.data) < 0){
			if(right == null){
				this.right = node;
			} else {
				//forward insert to next node
				this.right.insert(node);
			}
		//insert left
		} else { 
			if(left == null){
				this.left = node;
			} else {
				//forward insert to next node
				this.left.insert(node);
			}
		}
	}

    /**
     * searches for the node that has an euqal payload to the given TreeData
     * @param s the TreeData to look for
     * @return the Node that cointains equivalent TreeData or null if none can be found
     */
	public Node<T> find(T s) {
		int comp = this.data.compareTo(s);
		//walk the tree recursivly
		if(comp == 0){
			return this;
		} else if(comp > 0){
			if(left != null) {
				return left.find(s);
			} else {
				return  null;
			}
		} else {
			if(right != null) {
				return right.find(s);
			} else {
				return right;
			}
		}
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}
}
