package de.tuberlin.prog1.collections;

import java.io.IOException;

public class Fehler {

	public static Exception baumSize() {
		return new Exception("Der Baum ist groeßer als erlaubt!");
	}

	public static Exception schreiben(IOException e) {
		return new Exception("Es gab ein Fehler beim Schreiben",e);
	}

	public static Exception lesen(IOException e) {
		return new Exception("Es gab ein Fehler beim Lesen",e);
	}

	public static Exception falschGelesen() {
		return new Exception("Der Baum wurde falsch eingelesen!");
	}

}
