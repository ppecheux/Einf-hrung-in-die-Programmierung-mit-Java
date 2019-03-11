package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;

public class Book extends Product {

	/**
	 * title of the book
	 */
	private final String title;

	/**
	 * author of the book
	 */
	private final String author;

	/**
	 * publisher of the book
	 */
	private final String publisher;

	/**
	 * edition of the book
	 */
	private final int edition;

	public Book(String author, String title, String publisher, int edition, double price) {
		super(price);
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.edition = edition;
	}

	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", edition=" + edition
				+ ", price=" + getPrice() + "]";
	}

	public static Book createBookFromUserinput() {
		System.out.println("Book creation:");
		String author = IOTools.readLine("Enter the book's author: ");
		String title = IOTools.readLine("Enter the book's title: ");
		String publisher = IOTools.readLine("Enter the book's publisher: ");
		int edition = IOTools.readInt("Enter the book's edition: ");
		double price = IOTools.readDouble("Enter the book's price in €: ");
		return new Book(author, title, publisher, edition, price);
	}

}
