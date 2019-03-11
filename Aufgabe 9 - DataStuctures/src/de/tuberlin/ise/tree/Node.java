package de.tuberlin.ise.tree;

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
		if(this.data.compareTo(node.data)<0){
			if(this.left==null)
				this.left=node;
			else
				this.left.insert(node);
		}
		else if(this.data.compareTo(node.data)>0){
			if(this.right==null)
				this.right=node;
			else
				this.right.insert(node);
		}
	}

    /**
     * searches for the node that has an euqal payload to the given TreeData
     * @param s the TreeData to look for
     * @return the Node that cointains equivalent TreeData or null if none can be found
     */
	public Node<T> find(T s) {
		if(this.data.compareTo(s)<0){
			if(this.left==null)
				return null;
			else
				this.left.find(s);
		}
		else if(this.data.compareTo(s)>0){
			if(this.right==null)
				return null;
			else
				this.right.find(s);
		}
		//else == s ist gleich this.data
		return this;
		
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}
}
