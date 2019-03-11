package de.tuberlin.ise.prog1.onlineshop.products;

import Prog1Tools.IOTools;

/**
 * This class implements a product
 * 
 * @author jacobeberhardt
 *
 */
public class Product {
	/**
	 * class variable as helper for Id generation
	 */
	private static int nextId = 0; //independant de l'instance
	
	/**
	 * id of the product
	 */
	private final int id;

	/**
	 * name of the product
	 */
	private final String name;

	/**
	 * description of the product
	 */
	private final String description;
	
	/**
	 * price of the product
	 */
	private final double price;

	/**
	 * Constructor for product. Id is automatically generated.
	 * @param name
	 * @param description
	 * @param price
	 */
	Product(String name, String description, double price) {
		id = nextId++;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + ", price=" + price + "€" + "]";
	}

	public static Product createProductFromUserinput() {
		System.out.println("Product creation:");
		String name = IOTools.readString("Enter a product name: ");
		String description = IOTools.readLine("Enter a product description: ");
		double price = IOTools.readDouble("Enter the product's price in â‚¬: ");
		return new Product(name, description, price);
	}
}
