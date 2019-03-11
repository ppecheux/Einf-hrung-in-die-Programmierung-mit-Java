package de.tuberlin.ise.prog1.onlineshop;

public class WarehouseItem {
	
	private Product product;// classen variablen
	private int stock;
	
	WarehouseItem(Product product, int stock){//constructor
		setProduct(product);
		setStock(stock);
	}
	WarehouseItem(Product product){//constructor
		setProduct(product);
		setStock(0);
	}
	public String toString(){
		return product.toString()+" with a stock of "+ this.getStock()+"items";
	}
	
	public int getStock() {
		return stock;
	}
	void setStock(int stock) {
		if (stock<0){
			System.out.println("darf nicht kleiner als null sein");
			return;
		}
		this.stock = stock;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
