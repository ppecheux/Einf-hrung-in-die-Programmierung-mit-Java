package de.tuberlin.ise.prog1.utils;

public enum Carrier {
	DHL,UPS,FEDEX,HERMES,DPD;
	
	public static Carrier read(String s){
		switch(s){
		case"DHL":return DHL;
		case"UPS":return UPS;
		case "FEDEX":return FEDEX;
		case "HERMES":return HERMES;
		case "DPD":return DPD;
		}
		return DHL;
	}

}
