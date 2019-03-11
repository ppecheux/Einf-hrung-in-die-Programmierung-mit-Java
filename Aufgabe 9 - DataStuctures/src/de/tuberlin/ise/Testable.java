package de.tuberlin.ise;

public interface Testable<T extends Comparable<T>> {
	
	public boolean add(T value);
	public boolean contains(T value);
	

}
