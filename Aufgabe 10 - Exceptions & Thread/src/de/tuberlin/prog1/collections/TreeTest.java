package de.tuberlin.prog1.collections;

import java.io.IOException;
import java.util.Random;

public class TreeTest {
	public static void main(String[] args) throws Exception {
		BinTree<Integer> tree = new BinTree<>(20);
		
		Random rand = new Random();
		
		for (int i = 0; i < 25; i++) {
			try{
				tree.add(rand.nextInt(1024));
			}catch(BinTreeSizeException e){}
		}
		
		if(tree.size() > 20) { throw Fehler.baumSize(); }
		
		int sum = 0;
		for (int i = 0; i < 1024; i++) {
			try{
				sum += tree.find(i);
			}catch(BinTreeFindNull e){}
		}
		
		System.out.printf("tree sum: %d\n",sum);
		System.out.printf("tree looks like: %s\n",tree);
		
		
		try {
			BinTreeIO.write(tree, "test.tree");
		} catch (IOException e) {
			throw Fehler.schreiben(e);
		}
		
		tree = null;
		try {
			tree = BinTreeIO.read("test.tree");
		} catch (IOException e) {
			throw Fehler.lesen(e);
		}
		
		if(tree.size() != 20 && tree.getLimit() != 20) { throw Fehler.falschGelesen(); }
		
		sum = 0;
		for (int i = 0; i < 1024; i++) {
			sum += tree.find(i);
		}
		
		System.out.printf("tree sum: %d\n",sum);
		System.out.printf("tree looks like: %s\n",tree);
		
	}
}
