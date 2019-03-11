package de.tuberlin.ise.prog1.onlineshop;

import de.tuberlin.ise.prog1.utils.Carrier;
import de.tuberlin.ise.prog1.utils.DeliveryMode;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Shippable;

/**
 * Instances of this class can be held in a warehouse. They contain a product and a stock level.
 * @author Pecheux
 *
 */
public class WarehouseItem implements Shippable{
	private Product product;
	private int stock;

	WarehouseItem(Product product, int stock) {
		this.product = product;
		this.stock = stock;
	}

	WarehouseItem(Product product) {
		this(product, 0);
	}

	void setStock(int stock) {
		if (stock >= 0) {
			this.stock = stock;
		} else {
			System.out
					.println("Stock value could not be updated. Negative values not allowed.");
		}
	}

	public int getStock() {
		return stock;
	}

	public Product getProduct() {
		return product;
	}
	/*
	 * Implementieren Sie nun die durch das Interface vorgeschriebene Methode ship : Falls der Lagerbestand eines WarehouseItems WarehouseItems groß genug ist, um die angeforderte Menge ausliefern zu können, so soll der Lagerbestand um diese Menge reduziert werden und eine Erfolgsmeldung, welche ProduktId, Empfänger, Menge, Transportdienstleister und Zustellungsart enthält, auf der Konsole ausgegeben werden. Zudem ist die verbleibende Lagermenge auszugeben.
Andernfalls soll eine Fehlermeldung auf der Konsole ausgegeben werden, die auf einen zu geringen Lagerbestand hinweist.
	 * */

	public void ship(String recipient, DeliveryMode deliveryMode,
			Carrier carrier, int quantity) {
		if (this.getStock()>quantity){
			this.setStock(getStock()-quantity);
			System.out.println(quantity+" units of product with id "+this.getProduct().getId()+" shipped by "+carrier+" to "+recipient+" with delivery mode "+deliveryMode);
			System.out.println("Remaining quantity: "+this.getStock());
		}
		else{
			System.out.println("Sorry our stock is currently of "+this.getStock());
		}
		
	}

}
