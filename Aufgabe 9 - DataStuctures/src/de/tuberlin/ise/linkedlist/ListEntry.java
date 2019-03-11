package de.tuberlin.ise.linkedlist;



public class ListEntry<T> {

	/**value of this list entry*/
	public T value;
	
	/**references to the successor and predecessor of this list entry*/
	public ListEntry<T> next;
	public ListEntry<T> prev; 
	
	ListEntry(){
		
	}
	
	ListEntry(ListEntry<T> next){
		this.next = next;
	}
}
