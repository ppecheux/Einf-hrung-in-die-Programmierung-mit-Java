package de.tuberlin.prog1.collections;

import java.util.ArrayList;

/**
 * A Binary Tree Class that stores {@link TreeData}-Objects
 */
public class BinTree<T extends Comparable<T>> {
	Node<T> root;
	int size = 0;

	final int limit;
	public BinTree(int limit) throws BinTreeSizeException {
		if(limit <= 0) {
			throw new IllegalArgumentException("Tree limit must be at least 1");
		}
		if(size>limit)
			throw new BinTreeSizeException();
		else
			this.limit = limit;
	}
	
    /**
     * Insert a new TreeData Object into the three
     * @param data object to be inserted
     * @throws BinTreeSizeException 
     */
	public void insert(T data) throws BinTreeSizeException{
		if(root == null){
			root = new Node<T>(data);
		} else {
			if(size==limit)
				throw new BinTreeSizeException();
			else
				root.insert(new Node<T>(data));
		}
		size++;
	}

    /**
     * Number of elements in the Tree
     * @return
     */
	public int size(){
	    return this.size;
    }

	private void toString(Node<T> node,StringBuilder builder){
		builder.append("[");
		if(node != null){
			
			if(node.getLeft() != null){
				toString(node.getLeft(),builder);
				builder.append("<");
			} else {
				builder.append("");
			}
			
			builder.append(node.getData());
			
			if(node.getRight() != null){
				builder.append(">");
				toString(node.getRight(),builder);
			} else {
				builder.append("");
			}
			
		}
		builder.append("]");
	}
	
    /**
     * @return String representaton of this Tree
     */
	public String toString(){
		StringBuilder b = new StringBuilder();
		toString(root,b);
		return b.toString();
	}

	/**
	 * returns all elements of this tree in preorder
	 * @return
	 */
	public ArrayList<T> toPreOrderList() {
		ArrayList<T> list = new ArrayList<>();
		//TODO
		return list;
	}
	
	
    /**
     * Searchs for a Node that contains a TreeData element
     *  that is equal to the given element.
     * @param s Element to be serached for
     * @return the first Node that contains an equivalent element or null if non can be found
     */
	private Node<T> findNode(T s){
		if(root.getData().compareTo(s) == 0){
			return root;
		} else {
			return  root.find(s);
		}
		
	}

    /**
     * finds a TreeData Object equivalent to the one specified
     * @param s
     * @return 
     * @throws BinTreeFindNull 
     */
	public T find(T s) throws BinTreeFindNull{
		Node<T> node = findNode(s);
		if(node != null){
		    return node.getData();
        } else {
		    throw new BinTreeFindNull();
        }
	}

	public boolean add(T value) throws BinTreeSizeException {
		insert(value);
		return true;
	}

	public boolean contains(T value) throws BinTreeFindNull {
		return find(value) != null;
	}

	public int getLimit() {
		return limit;
	}


   
}
