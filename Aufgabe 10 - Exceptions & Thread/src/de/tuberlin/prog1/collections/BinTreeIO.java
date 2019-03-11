package de.tuberlin.prog1.collections;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import de.tuberlin.prog1.io.FileUtil;

public class BinTreeIO {
	
	
	/**
	 * this method attempts to parse the given file into a binTree object
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws BinTreeSizeException 
	 */
	public static BinTree<Integer> read(String file) throws IOException, BinTreeSizeException{
		ArrayList<String> lines = FileUtil.readLines(file);
		
		Scanner sc= new Scanner(file);
		
		int limit = -1;
		limit = sc.nextInt();
		int checksum=sc.nextInt();
		//parsen sie das limit aus der ersten zeile und die checksum aus der ersten zeile
		
		BinTree<Integer> tree = new BinTree<>(limit);
		
		//parsen sie nun alle anderen zielen und fügen sie die Konten in der richtigen reinfolge hinzu
		
		//vergleichen sie nun die eingelesenen checksum mit der akutellen checksum des baumes...
		sc.close();
		
		return tree;
		
	}
	
	/**
	 * this method attempts write a tree object to given file
	 * @param file
	 * @throws IOException
	 */
	public static void write(BinTree<Integer> tree,String file) throws IOException {
		ArrayList<String> lines = new ArrayList<>();
		ArrayList<Integer> preeorder = tree.toPreOrderList();
		
		//TODO wandeln sie die preeoder liste in eine liste von strings um und fügen sie das baum header zuerst in die lines-liste hinzu
		
		
		FileUtil.writeArrayListToFile(file,lines);
	}
	
	//don't touch this ;)
	private static int checksum(BinTree<Integer> tree) {
		int sum = 0;
		for(Integer i : tree.toPreOrderList()) {
			sum += (i*(sum+1))%731;
		}
		return sum;
		
	}
	
}
