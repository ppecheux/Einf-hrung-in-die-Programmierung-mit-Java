package de.tuberlin.ise.prog1;

public class Main {
	
	public static void main(String[] args) {
		SkipList<String> list = new SkipList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		
		System.out.printf("test get(1) should be:a is:%d\n",list.get(1));
		
		System.out.printf("test contains(j) should be:true is:%b\n",list.contains("j"));
		System.out.printf("test contains(k) should be:false is:%b\n",list.contains("k"));
		System.out.printf("test contains(a) should be:true is:%b\n",list.contains("e"));
		
		System.out.printf("test toString() should be:\n"
				+ "head -> 1 -> 7 -> 21 -> 36 -> null\r\n" + 
				"head -> 1 -> 3 -> 6 -> 7 -> 12 -> 14 -> 21 -> 34 -> 36 -> 37 -> null\r\n" + 
				"\nis:\n%s\n",list);
	}

	
}
