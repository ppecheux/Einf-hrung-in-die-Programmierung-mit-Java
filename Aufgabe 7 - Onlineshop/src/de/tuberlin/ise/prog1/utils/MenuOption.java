package de.tuberlin.ise.prog1.utils;

public enum MenuOption {
	
	LIST,
	REGISTER,
	ADJUST_STOCK,
	EXIT,
	SHIP,
	;
	
	
	public static MenuOption optionForNumber(int n){
		switch(n){
		case 0:return LIST;
		case 1:return REGISTER;
		case 2:return ADJUST_STOCK;
		case 3:return EXIT;
		case 4:return SHIP;
		}
		return LIST;
	}

}
