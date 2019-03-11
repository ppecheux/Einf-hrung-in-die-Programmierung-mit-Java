package de.tuberlin.ise.prog1.onlineshop;

import de.tuberlin.ise.prog1.onlineshop.products.Product;

import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Television;
import Prog1Tools.IOTools;


/**
 * Instances of this class can be held in a warehouse. They contain a product and a stock level.
 * @author Pecheux
 *
 */
public class WarehouseItem {
	private Product product;
	private int stock;

	WarehouseItem(Product product){
		this.product=product;
		this.stock=0;
	}
	
	WarehouseItem(Product product, int stock){
		this(product);
		this.stock=stock;
	}

	void setStock(int stock) {
		if (stock >= 0) {
			this.stock = stock;
		} else {
			System.out.println("Stock value could not be updated. Negative values not allowed.");
		}
	}

	public int getStock() {
		return stock;
	}

	public Product getProduct() {
		return product;
	}

}
