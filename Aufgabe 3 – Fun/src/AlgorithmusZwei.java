import Prog1Tools.IOTools;

public class AlgorithmusZwei {
	public static void main(String[]args){
	int summe = 0;//initializierung
	int n,m;//deklaration
	do{
		n = IOTools.readInt("entrer the first number");
		m = IOTools.readInt("entrer the second number");
		if (m!=0 && n!=0 && n!=m){ // Das ist die Bedigung um die Schleiffe zu weg gehen
			break;  
		}
	}while(true);
	
	for (int i=0; i<1000; i++){
		if((i%n==0) || (i%m==0)){//genauso wie die erste Klasse
			summe+=i;
		}
	}
	System.out.println(summe);
	}
}
	
