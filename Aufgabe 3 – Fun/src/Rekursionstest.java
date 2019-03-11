
public class Rekursionstest {
	public static void printZahl(int n){
		if (n < 1){
			return;
		}
		if (n==1){
			System.out.println("1");// bedigung ende des rekurtion
		}
		else{
			System.out.println(n + " , ");// rekurtion
			printZahl(n-1);
		}
	}
	
	public static void main(String[] args){// Um tests zu machen
		printZahl(-1);
	}

}
