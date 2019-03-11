package de.tuberlin.ise.prog1.onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Television;


/**
 * Instances of this class represent warehouses. Warehouses store products and provide means for insertion and retrieval.
 * 
 * @author PierreLouis Pecheux
 *
 */
public class Warehouse {

	private WarehouseItem[] warehouseContent = new WarehouseItem[0];

	/**
	 * This method registers products in the warehouse. The stock value is set to 0
	 * @param products
	 */
	public void registerProducts(Product... products) {
		WarehouseItem[] updatedWarehouseContent = new WarehouseItem[warehouseContent.length
				+ products.length];
		int i = 0;
		for (; i < warehouseContent.length; i++) {
			updatedWarehouseContent[i] = warehouseContent[i];
		}
		for (; i < updatedWarehouseContent.length; i++) {
			updatedWarehouseContent[i] = new WarehouseItem(products[i - warehouseContent.length]);
		}	
		warehouseContent=updatedWarehouseContent;
	}
	
	
	/**
	 * Sets the stock of the product with specified id. Stock can not be negative
	 * @param id, stock
	 */
	public void setStockForProductById(int id, int stock) {
		for (WarehouseItem w : warehouseContent) {
			if (w.getProduct().getId() == id) {
				w.setStock(stock);
			}
		}
	}
	
	/**
	 * Returns an instance of WarehouseItem where the associated product has the specified Id
	 * @param id, stock
	 */
	public WarehouseItem getWarehouseItemByProductId(int id){
		for (WarehouseItem w : warehouseContent) {
			if (w.getProduct().getId() == id) {
				return w;
			}
		}
		return null;
	}
	
	/**
	 * Prints an inventory list in the form [product id, product, stock, shippingOption] 
	 */
	public void printInventory(){
		for (WarehouseItem w : warehouseContent) {
			System.out.println("id: " +  w.getProduct().getId()+ ", product: " + w.getProduct().toString() + ", stock:"  + w.getStock());
		}
	}
	
	
	/**
	 * loads an initial data set from the file inputdata.csv
	 * 
	 * * @return a Product[], will never be null but may have length 0
	 */
	public static Product[] preloadInitialDataSet() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("inputdata.csv"));
			ArrayList<Product> p = new ArrayList<Product>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] splits = line.split(";");
				if ((splits.length == 6)&&(splits[0].equals("B"))){
					//handle books
					Book b;
					b = new Book(splits[1], splits[2], splits[3], Integer.parseInt(splits[4]), Double.parseDouble(splits[5]));
					p.add(b);
				} 
				else if((splits.length == 5)&&(splits[0].equals("T"))){
					Television t;
					//handle televisions
					t = new Television(splits[1], Integer.parseInt(splits[2]), Boolean.parseBoolean(splits[3]), Double.parseDouble(splits[4]));
					p.add(t);
				}
				else {
					System.out.println("Could not process line:" + line);
				}
			}

			return p.toArray(new Product[p.size()]);

		} catch (Exception e) {
			System.out
					.println("There was an error while trying to load the initial data set:");
			e.printStackTrace();
			return new Product[0];
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
	}
	

}
