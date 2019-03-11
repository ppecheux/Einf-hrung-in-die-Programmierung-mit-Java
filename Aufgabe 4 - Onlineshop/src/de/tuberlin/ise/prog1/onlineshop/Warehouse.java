package de.tuberlin.ise.prog1.onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Instances of this class represent warehouses. Warehouses store products and provide means for insertion and retrieval.
 * 
 * @author jacobeberhardt
 *
 */
public class Warehouse {
	
	private WarehouseItem[] warehouse = new WarehouseItem[0];
	
	public void registerProducts(Product... products){
		WarehouseItem[] newItem = new WarehouseItem[products.length+this.warehouse.length];
		for(int i=0;i<warehouse.length;i++){
			newItem[i]=warehouse[i];
		}
		for(int i=warehouse.length; i<newItem.length;i++){
			newItem[i]=new WarehouseItem(products[i]);
		}
		warehouse=newItem;
	}
	
	public void setStockForProductById(int idnummer,int stock){
		
		warehouse[idnummer].setStock(stock);
	}
	
	public void printInventory(){
		for(WarehouseItem i:warehouse){
			System.out.println(i.toString());
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
				if (splits.length == 3) {
					p.add(new Product(splits[0], splits[1], Double.parseDouble(splits[2])));
				} else {
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

	public WarehouseItem[] getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(WarehouseItem[] warehouse) {
		this.warehouse = warehouse;
	}
	

}
