package de.tuberlin.ise.skiplist;

/**
 * List entries used and managed by BaseList
 * @author jacobeberhardt
 *
 */
public class BaseListEntry<T  extends Comparable<T>> {
	protected BaseListEntry<T> next;
	protected T value;
	
	public BaseListEntry(T value, BaseListEntry<T> next){
		this.value = value;
		this.next = next;
	}
	

}
