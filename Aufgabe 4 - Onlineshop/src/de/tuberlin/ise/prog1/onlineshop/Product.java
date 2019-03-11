package de.tuberlin.ise.prog1.onlineshop;

import Prog1Tools.IOTools;

public class Product {
	
	private final String name;
	private final String description;
	private double price;
	private final int id;
	private static int nextId ;
	
	public Product(String n,String des,double price) {
		setNextId(getNextId()+1);
		this.name = n;
		this.setPrice(price);
		this.description = des;
		this.id = getNextId();
	}

	static public Product createProductFromUserinput(){
		String name = IOTools.readString("Geben Sie bitte den Namen ein");
		String description = IOTools.readString("Geben Sie bitte die Beschreibung ein");
		double price = IOTools.readDouble("Geben Sie bitte den Preis ein");
		Product neu = new Product(name,description,price);
		return neu;
	}
	
	public String toString(){
		return this.name+" ist beschrieben als " + this.description+" kostet " 
				+ this.price +" id ist " + getId();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}

}
