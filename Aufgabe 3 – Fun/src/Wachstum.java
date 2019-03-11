
public class Wachstum {
	public static void main(String[] args) {
		int[] daten = new int[0];
		daten = join(new int[] {12,213,42,523,123}, daten);
		print(daten);
		daten = join(new int[] {19,1991,1999,9919,9199}, daten);
		print(daten);
		}
		/**
		* hängt das gegebene neu-Array an das daten-Array an und gibt es zurück.
		* @param neu
		* @param daten
		* @return
		*/
		static int[] join(int[] neu, int[] daten) {
			
			int [] array = new int[neu.length + daten.length]; // hier mann initializiert die lange des listes
			
			int i = 0;
			while (i < daten.length){// erstens mann speichert die Werte die in die daten liste sind
				array[i]=daten[i];
				i++;
			}
			while (i< array.length){//dann speichert mann die Daten von die neue Liste.
				array[i]=neu[i-daten.length];
				i++;						
			}
			return array;
		}
		/**
		* Diese Methode gibt das gegebene Array auf der Konsole aus * @param daten
		*/
		
		
		static void print(int[] daten) {
			for(int d : daten){
				System.out.print(d+ " , ");
			}
		}

}
