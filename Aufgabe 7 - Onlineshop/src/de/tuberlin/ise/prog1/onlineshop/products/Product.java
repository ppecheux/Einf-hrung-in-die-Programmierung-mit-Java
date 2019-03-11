package de.tuberlin.ise.prog1.onlineshop.products;


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
	private static int nextId = 0;
	
	/**
	 * id of the product
	 */
	private final int id;
	
	/**
	 * price of the product
	 */
	private final double price;

	/**
	 * Constructor for product. Id is automatically generated.
	 * @param price
	 */
	protected Product(double price) {
		id = nextId++;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Product [id=" + id + ", price=" + price + "€" + "]";
	}

}
