package de.tuberlin.ise.skiplist;

/**
 * 
 * @author jacobeberhardt
 *
 *         Sorted Singly linked list containing positive integers. Serves as
 *         complete list the index list refers to in the skiplist implementation.
 */
public class BaseList<T extends Comparable<T>> {

	protected BaseListEntry<T> head = null;

	/**
	 * inserts integer number into sorted list of integers. Returns the reference of the inserted list item.
	 * 
	 * @param value
	 */
	protected BaseListEntry<T> add(T value) {
		BaseListEntry<T> result = null;
		if (head == null) {
			head = new BaseListEntry<T>(value, null);
			result = head;
		} else {
			BaseListEntry<T> temp = head;
			while ((temp.next != null) && (temp.next.value.compareTo(value) < 0)) {
				temp = temp.next;
			}
			if (temp.next == null) {
				temp.next = new BaseListEntry<T>(value, null);
			} else {
				temp.next = new BaseListEntry<T>(value, temp.next);
			}
			result = temp.next;
		}
		return result;
	}

	/**
	 * returns the number at the index specified. Index starts with 0.
	 * 
	 * @param index
	 * @return
	 */
	protected T get(int index) {
		BaseListEntry<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		if (temp != null) {
			return temp.value;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns a reference to the list item at the specified index position. Can be null.
	 * @param index
	 * @return reference to the list item at the specified index position
	 */
	protected BaseListEntry<T> getBaseListEntry(int index) {
		BaseListEntry<T> temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * Checks, whether a number is contained in the list starting from a list entry specified as a parameter
	 * @param value
	 * @param pointer
	 * @return boolean value whether number is contained in list
	 */
	public boolean contains(T value, BaseListEntry<T> pointer) {
		BaseListEntry<T> temp = pointer;
		while (temp.value != value) {
			if (temp.next == null)
				return false;
			if (temp.next.value.compareTo(value) < 0) {
				return false;
			}
			temp = temp.next;
		}
		return true;
	}
	
	public boolean contains(T value) {
		BaseListEntry<T> temp = head;
		while (temp.value != value) {
			if (temp.next == null)
				return false;
			if (temp.next.value.compareTo(value) == 0) {
				return true;
			}
			temp = temp.next;
		}
		return true;
	}


	/**
	 * @return String representation of the list.
	 */
	public String toString() {
		BaseListEntry<T> temp = head;
		String result = "head";
		while (temp != null) {
			result = result + " -> " + temp.value;
			temp = temp.next;
		}
		result = result + " -> null";
		return result;
	}

}
