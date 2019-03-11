package de.tuberlin.ise.prog1;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		SkipList list = new SkipList();

		
		List<Integer> daten = Arrays.asList(1,3,6,7,12,14,21,34,36,37);
		
		
		
		list.addAll(daten);
		
		System.out.printf("test get(5) should be:14 is:%d\n",list.get(5));
		System.out.printf("test size() should be:10 is:%d\n",list.size());
		
		System.out.printf("test contains(7) should be:true is:%b\n",list.contains(7));
		System.out.printf("test contains(37) should be:true is:%b\n",list.contains(37));
		System.out.printf("test contains(-1) should be:false is:%b\n",list.contains(-1));
		
		System.out.printf("test toString() should be:\n"
				+ "head -> 1 -> 7 -> 21 -> 36 -> null\r\n" + 
				"head -> 1 -> 3 -> 6 -> 7 -> 12 -> 14 -> 21 -> 34 -> 36 -> 37 -> null\r\n" + 
				"\nis:\n%s\n",list);	
		
	}

	
}
