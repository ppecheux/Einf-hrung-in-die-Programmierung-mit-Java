package de.tuberlin.ise.prog1.onlineshop.products;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import Prog1Tools.IOTools;

public class Television extends Product{
	
	private final String manufacturer;
	private final int screensize;
	private final boolean reciever;
	
	public Television(double price,String manu, int scr, boolean rec) {
		super("Television", "to watch series and films", price);
		this.manufacturer=manu;
		this.screensize=scr;
		this.reciever=rec;
	}
	public static Television createTelevisionFromUserinput(){
		System.out.println("Television creation:");
		String manufacturer = IOTools.readString("Enter the manufacturer's name: ");
		int screensize = IOTools.readInt("Enter the television's screensize: ");
		boolean reciever = IOTools.readBoolean("There is a reciever: ");
		double price = IOTools.readDouble("Enter the book's price in €: ");
		return new Television( price, manufacturer, screensize,reciever);
	}
	
	public String toString(){
		return super.toString()+"Television [manufacturer=" + manufacturer + " screensize=" +screensize +"reciever="+reciever;
	}

}
