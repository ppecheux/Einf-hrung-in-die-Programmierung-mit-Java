package de.tuberlin.ise.array;

import java.util.ArrayList;

import de.tuberlin.ise.Testable;

public class ArrayListAdapter<T extends Comparable<T>> implements Testable<T> {
	
	private ArrayList<T> backend = new ArrayList<T>();

	
	public void sort() {//insertion sort
		 for(int i=1;i<backend.size();i++){
			 T key = backend.get(i);
			 for(int j= i-1;j>=0;j--){
				 if(key.compareTo(backend.get(i))<0){
					 // Shifting Each Element to its right as key is less than the existing element at current index
					 backend.set(j+1,backend.get(j));
					 // Special case scenario when all elements are less than key, so placing key value at 0th Position
					 if(j==0){
						 backend.set(0, key);
						 }
	                }else{
	                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
	                	backend.set(j+1,key);
	                    break; // You need to break the loop to save an necessary iteration
	                }
	            }
		 }
	}
	
	public int binSearch(T key) {
		int end = backend.size()-1;
		int begin = 0;
		
		while(end!=begin){
			if(key.compareTo(backend.get((int)(end-begin)/2))>0)
				begin=((int)(end-begin)+1/2);
			
			else
				end=((int)(end-begin)/2);
		}
		if(backend.get(end)==key)return 0;
		return 1;
	}
	
	public boolean contains(T value) {
		sort();
		return binSearch(value) >= 0;
	}
	
	public boolean add(T value) {
		return backend.add(value);
	}
	
}
