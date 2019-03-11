import java.util.ArrayList;


public class ArrayListvsLinked {
	public static void main (String[]args){
		
		ArrayList<String> arrlist;//declaration
		arrlist= new ArrayList<>();//initialisation
		int n = 10;
		long time= System.currentTimeMillis();
		for(int i=0;i<10*n;++i){
			String str = "string example "+i;
			arrlist.add(str);
		}
		for(int i=0;i<5*n;++i){
			System.out.println(arrlist.get(i));
		}
		time= (-time)+System.currentTimeMillis();
		System.out.println("this took "+ time+" millisec");
		
	}

}
