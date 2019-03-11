// Willkommen zum Abgabe 3
public class Algorithmus {
	public static void main (String[]args){
		int summe = 0; // initialization der Summe
		
		for (int i=0; i<1000; i++){
			if((i%3==0) || (i%5==0)){
				summe+=i; // implementierung
			}
		}
		System.out.println(summe);		
	}

}
