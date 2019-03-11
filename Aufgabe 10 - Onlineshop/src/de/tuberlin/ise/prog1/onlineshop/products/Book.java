package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;
import de.tuberlin.ise.prog1.onlineshop.products.Product;

public class Book extends Product{
	
	private final String author;
	private final String title;
	private final String publisher;
	private final int  edition;
	
	//public constructor so dass es 

	public Book(double price,String authorn, String titlen, String publishern, int editionn) {
		super("Book", "to read and turn pages", price);
		this.author= authorn;
		this.title= titlen;
		this.publisher= publishern;
		this.edition= editionn;
	}
	
	public static Book createBookFromUserinput(){
		System.out.println("Book creation:");
		String author = IOTools.readString("Enter the author's name: ");
		String title = IOTools.readLine("Enter the book's title: ");
		String publisher = IOTools.readLine("Enter the book's publisher: ");
		int edition = IOTools.readInt("Enter the book's edition: ");
		double price = IOTools.readDouble("Enter the book's price in €: ");
		return new Book( price, author, title,publisher, edition);
	}
	
	public String toString(){
		return super.toString() + "Book [author=" + getAuthor() + " title=" + getTitle()+ 
				" publisher=" + getPublisher() + " edition=" + getEdition()+ "]";
	}
	

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getEdition() {
		return edition;
	}

}
