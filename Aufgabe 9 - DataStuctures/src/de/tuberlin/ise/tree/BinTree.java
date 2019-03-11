package de.tuberlin.ise.tree;

import de.tuberlin.ise.Testable;

/**
 * A Binary Tree Class that stores {@link TreeData}-Objects
 */
public class BinTree<T extends Comparable<T>> implements Testable<T>{
	Node<T> root;
	int size = 0;

    /**
     * Insert a new TreeData Object into the three
     * @param data object to be inserted
     */
	public void insert(T data){
		if(root == null){
			root = new Node<T>(data);
		} else {
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
				builder.append("NULL<");
			}
			
			builder.append(node.getData());
			
			if(node.getRight() != null){
				builder.append(">");
				toString(node.getRight(),builder);
			} else {
				builder.append(">NULL");
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
     * Searchs for a Node that contains a TreeData element that is equal to the
     * given element.
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
     */
	public T find(T s){
		Node<T> node = findNode(s);
		if(node != null){
		    return node.getData();
        } else {
		    return null;
        }
	}

	//@Override
	public boolean add(T value) {
		insert(value);;
		return true;
	}

	//@Override
	public boolean contains(T value) {
		return find(value) != null;
	}

   
}
