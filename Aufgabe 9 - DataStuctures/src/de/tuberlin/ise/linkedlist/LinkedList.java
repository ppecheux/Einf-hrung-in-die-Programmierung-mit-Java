package de.tuberlin.ise.linkedlist;

import java.util.Collection;
import java.util.Iterator;

import de.tuberlin.ise.Testable;

public class LinkedList<T extends Comparable<T>> implements Collection<T>,Testable<T>{

	/** head of the list */
	private ListEntry<T> head;
	
	private int size = 0;

	/**
	 * inserts a values at the end of the list
	 * 
	 * @param value
	 *            value which shall be added
	 */
	public boolean add(T value) {
		if (head == null) {
			// insert at head
			head = new ListEntry<T>();
			head.value = value;
			size++;
			return true;
		}
		// find end
		ListEntry<T> current = head, last = head;
		while (current != null) {
			last = current;
			current = current.next;
		}
		current = new ListEntry<T>();
		current.value = value;
		current.prev = last;
		last.next = current;
		size++;
		return true;
	}

	/**
	 * inserts a value at the head of the list
	 * 
	 * @param value
	 *            value which shall be added
	 */
	public void insertAtHead(T value) {
		if (head == null) {
			head = new ListEntry<T>();
			head.value = value;
			size++;
			return;
		}
		ListEntry<T> newHead = new ListEntry<T>();
		newHead.value = value;
		newHead.next = head;
		head.prev= newHead;
		head = newHead;
		size++;
	}

	/**
	 * inserts a value after the entry with the value "after" or at the end of
	 * the list if the value is not contained
	 * 
	 * @param value
	 *            value which shall be added
	 * @param after
	 *            desired predecessor for value
	 */
	public void insertAfter(T value, T after) {
		if (head == null) {
			head = new ListEntry<T>();
			head.value = value;
			size++;
			return;
		}
		ListEntry<T> newone = new ListEntry<T>();
		newone.value = value;
		ListEntry<T> current = head;
		while (current.next != null && current.value != after)
			current = current.next;
		ListEntry<T> temp = current.next;
		current.next = newone;
		newone.prev = current;
		newone.next = temp;
		
		size++;
	}

	/**
	 * 
	 * 
	 * @param position
	 * @return the value at position "position" or null if the list has less
	 *         entries
	 */
	public Object get(int position) {
		int counter = 0;
		ListEntry<T> current = head;
		while (current != null && position != counter++)
			current = current.next;
		if (current == null)
			return null;
		else
			return current.value;
	}

	/**
	 * deletes the specified value if contained in this list. Note: this method
	 * uses reference comparison, not equals()!
	 * 
	 * @param value
	 */
	private boolean delete(T value) {
		if (head == null)
			return false; // empty list
		ListEntry<T> current = head, last = head;
		if (current.value == value) {
			// it's the head element
			head = head.next;
			size--;
			return true;
		}
		while (current.next != null && current.value != value) {
			last = current;
			current = current.next;
		}
		if (current.value != value)
			return false; // not in this list
		
		last.next = current.next;
		if (current.next!=null)
		current.next.prev= last;
		
		size--;
		return true;

	}
	
	public boolean remove(Object value) {
		try {
			@SuppressWarnings("unchecked")
			T t = (T) value;
			return delete(t);
		} catch (ClassCastException e) {
			return false;
		}
	}
	
	private boolean find(T value) {
		ListEntry<T> current = head;
		if (current == null)
			return false;
		while (current != null && current.next != null) {
			if(current.value.equals(value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean contains(Object value) {
		try {
			@SuppressWarnings("unchecked")
			T t = (T) value;
			return find(t);
		} catch (ClassCastException e) {
			return false;
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ListEntry<T> current = head;
		if (current == null)
			return "[]";
		String res = "[";
		while (current != null && current.next != null) {
			res += current.value + ",";
			current = current.next;
		}
		res += current.value + "]";
		return res;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			ListEntry<T> current = new ListEntry<>(head);
		
			@Override
			public boolean hasNext() {
				return current != null && current.next != null;
			}

			@Override
			public T next() {
				current = current.next;
				return current.value;
			}
			
		};
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
		
	}
	
	@Override
	@Deprecated
	public Object[] toArray() {
		return null;
	}

	@Override
	@Deprecated
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T t:c) {
			add(t);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object t:c) {
			remove(t);
		}
		return true;
	}

	@Override
	@Deprecated
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean contains(T value) {
		return find(value);
	}
	
}
