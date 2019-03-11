package de.tuberlin.ise.skiplist;

/**
 * List entry used and managed by SkipList.
 * 
 * @author jacobeberhardt
 *
 */
public class IndexListEntry<T extends Comparable<T>> {

	protected IndexListEntry<T> next;
	protected BaseListEntry<T> pointer;
	protected T value;

	public IndexListEntry(T value, IndexListEntry<T> next, BaseListEntry<T> pointer) {
		this.value = value;
		this.next = next;
		this.pointer = pointer;
	}

}
