package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;

public class Television extends Product{
	

	private final String manufacturer;
	private final int screensize;
	private final boolean receiver;
	
	public Television(String manufacturer, int screensize, boolean receiver, double price) {
		super(price);
		this.manufacturer=manufacturer;
		this.screensize=screensize;
		this.receiver=receiver;
	}

	public String toString() {
		return "Television [manufacturer=" + manufacturer + ", screensize=" + screensize + ", receiver=" + receiver
				+ ", price=" + getPrice() + "]";
	}
	
	public static Television createTelevisionFromUserinput() {
		System.out.println("Television creation:");
		String manufacturer = IOTools.readLine("Enter the television's manufacturer: ");
		int screensize = IOTools.readInt("Enter the television's screensize (in inch): ");
		boolean receiver = IOTools.readBoolean("Does the television have an integrated receiver (true/false)? ");
		double price = IOTools.readDouble("Enter the television's price in €: ");
		return new Television(manufacturer, screensize, receiver,  price);
	}
	
}
