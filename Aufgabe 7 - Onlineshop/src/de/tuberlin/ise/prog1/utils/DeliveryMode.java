package de.tuberlin.ise.prog1.utils;

public enum DeliveryMode {
	
	STANDARD,EXPRESS,OVERNIGHT,LOW_COST;
	
	 public static DeliveryMode read (String s){
		switch(s){
		case"STANDARD" :return STANDARD;
		case"EXPRESS": return EXPRESS;
		case"OVERNIGHT":return OVERNIGHT;
		case"LOW_COST":return LOW_COST;
		}
		return STANDARD;
	}

}
