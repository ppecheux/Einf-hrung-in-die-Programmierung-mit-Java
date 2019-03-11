package de.tuberlin.ise.skiplist;

import java.util.Collection;
import java.util.Iterator;

import de.tuberlin.ise.Testable;

/**
 * SkipList implementation based on two singly-linked lists.
 * 
 * @author jacob eberhardt, sebastian werner
 *
 */
public class SkipList<T extends Comparable<T>> implements Collection<T>,Testable<T> {

	private IndexListEntry<T> head = null;

	private final int indexMaxLength = 4; // 4 index fields
	private int indexListLength = 0;

	private BaseList<T> baseList = new BaseList<>(); // underlying list the index
												// list refers to
	private int baseListLength = 0;

	/**
	 * Inserts a number into the SkipList.
	 * 
	 * @param value
	 * @return 
	 */
	public boolean add(T value) {
		// Implementation specific: Inserts a number into the baselist and
		// updates the indexlist to ensure equal distribution of the index.
		BaseListEntry<T> reference = baseList.add(value);
		baseListLength++;

		if (indexListLength < indexMaxLength) {
			// index is not full
			if (head == null) {
				head = new IndexListEntry<T>(value, null, reference);
			} else {
				IndexListEntry<T> temp = head;
				while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
					temp = temp.next;
				}
				if (temp.next == null) {
					temp.next = new IndexListEntry<T>(value, null, reference);
				} else {
					temp.next = new IndexListEntry<T>(value, temp.next, reference);
				}
			}
			indexListLength++;
		} else {
			// index is full, rebalance
			IndexListEntry<T> currentIndex = head.next;

			// implicit floor function
			int intervalWidth = baseListLength / indexMaxLength;

			// interval size adjustment based on modulo operation
			int intervalAdj = baseListLength % indexMaxLength;

			int indexPosition = 0;
			for (int i = 1; i < indexMaxLength; i++) {
				int offset = 0;
				// adjust index position to minimize variance of interval size
				if (intervalAdj - i >= 0)
					offset = 1;
				indexPosition = indexPosition + intervalWidth + offset;
				BaseListEntry<T> newIndexTarget = baseList.getBaseListEntry(indexPosition);
				currentIndex.pointer = newIndexTarget;
				currentIndex.value = newIndexTarget.value;
				currentIndex = currentIndex.next;
			}
		}
		return true;
	}

	/**
	 * Returns the number at the specified position
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return baseList.get(index);
	}

	/**
	 * Checks, whether a number is contained in the list.
	 * @param value
	 * @return boolean value whether number is contained in list
	 */
	public boolean contains(T value) {
		boolean result;
		if (head == null) {
			result = false;
		} else {
			IndexListEntry<T> temp = head;
			while ((temp.next != null) && (temp.next.value.compareTo(value) <= 0)) {
				temp = temp.next;
			}
			result = baseList.contains(value, temp.pointer);
		}
		return result;
	}

	/**
	 * returns String representation of the list.
	 */
	public String toString() {
		IndexListEntry<T> temp = head;
		String result = "head";
		while (temp != null) {
			result = result + " -> " + temp.value;
			temp = temp.next;
		}
		result = result + " -> null";
		result = result + "\n" + baseList.toString();
		return result;
	}
	
	/**
	 * removes all elements form the list 
	 */
	@Override
	public void clear() {
		head = null;
		indexListLength = 0;
		baseList = new BaseList<>(); 
		baseListLength = 0;
	}
	
	/**
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return baseListLength;
	}

	//do not change the following methods
	
	@Override
	public boolean isEmpty() {
		return size() <= 0;
	}
	
	@Override
	public boolean contains(Object o) {
		try {
			@SuppressWarnings("unchecked")
			T casted = (T) o;
			return contains(casted) ;
		} catch (ClassCastException e) {
			return false;
		}
	}
	
	
	@Override
	@Deprecated
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o : c) {
			if(!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for(T t:c) {
			add(t);
		}
		return true;
	}

	@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	@Deprecated
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		//really slow way to implement this but should be some what understandable
		return new Iterator<T>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < size();
			}

			@Override
			public T next() {
				return get(index++);
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] obj = new Object[size()];
		for (int i = 0; i < size(); i++) {
			obj[i] = get(i);
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <X> X[] toArray(X[] a) {
		for (int i = 0; i < size(); i++) {
			a[i] = (X) get(i);
		}
		return a;
	}


}
