package de.tuberlin.ise;

import java.util.ArrayList;
import java.util.Random;

import de.tuberlin.ise.array.ArrayListAdapter;
import de.tuberlin.ise.linkedlist.LinkedList;
import de.tuberlin.ise.skiplist.SkipList;
import de.tuberlin.ise.tree.BinTree;

public class Main {
	
	
	
	public static void main(String[] args) {
		Random zufall = new Random();
		int size=50000;
		
		ArrayListAdapter<Integer> adapter= new ArrayListAdapter<Integer>();
		long adapterTime=test(adapter,generateData(zufall,size),generateData(zufall,size));
		System.out.println("adapterTime for size "+size+" is "+ adapterTime);
		
		LinkedList<Integer> linked= new LinkedList<Integer>();
		long linkedTime=test(linked,generateData(zufall,size),generateData(zufall,size));
		System.out.println("linkedTime for size "+size+" is "+ linkedTime);
		
		SkipList<Integer> skip= new SkipList<Integer>();
		long skipTime=test(skip,generateData(zufall,size),generateData(zufall,size));
		System.out.println("skipTime for size "+size+" is "+ skipTime);
		
		BinTree<Integer> tree= new BinTree<Integer>();
		long treeTime=test(adapter,generateData(zufall,size),generateData(zufall,size));
		System.out.println("adapterTime for size "+size+" is "+ treeTime);
		
	}

	private static ArrayList<Integer> generateData(Random zufall, int elements ) {
		ArrayList<Integer> data = new ArrayList<>();
		//generate data to insert
		for(int k = 0;k<elements;k++) {
			data.add(zufall.nextInt(1000));
		}
		return data;
	}

	private static ArrayList<Integer> addFindableData(Random zufall, ArrayList<Integer> data) {
		ArrayList<Integer> find = new ArrayList<>();
		for(int k = 0;k<100;k++) {
			if(zufall.nextBoolean()) {
				find.add(data.get(zufall.nextInt(data.size())));
			} else {
				find.add(1000+zufall.nextInt(1000)*(zufall.nextInt(1)-2));
			}
		}
		return find;
	}
	
	public static long test(Testable<Integer> toTest,ArrayList<Integer> data,ArrayList<Integer> find) {
		long time = System.nanoTime();
		for(Integer i:data) {
			toTest.add(i);
		}
		for(Integer i:find) {
			toTest.contains(i);
		}
		return System.nanoTime()-time;
	}
	

}
