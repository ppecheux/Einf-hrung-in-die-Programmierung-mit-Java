package de.tuberlin.ise.prog1.onlineshop;

import Prog1Tools.IOTools;

public class ProductManager {

	public static final int LIST = 0;
	public static final int REGISTER = 1;
	public static final int ADJUST_STOCK = 2;
	public static final int EXIT = 3;

	/**
	 * Provides a command line interface to interact with the product management system for an online shop
	 * @param args
	 */
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.registerProducts(Warehouse.preloadInitialDataSet());
		System.out.println("Welcome to the online shop product management");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:"
					+ "\n0 to list all products"
					+ "\n1 to register a new product"
					+ "\n2 to adjust stock levels" + "\n3 to exit.");
			int command = IOTools.readInt();
			switch (command) {
				case LIST :
					warehouse.printInventory();
					break;
				case REGISTER :
					Product p = Product.createProductFromUserinput();
					warehouse.registerProducts(p);
					System.out.println("The following product has been added to the catalog:\n"
									+ p.toString());
					break;
				case ADJUST_STOCK :
					int id = IOTools.readInt("Please, enter product id:");
					int stock = IOTools.readInt("Please, enter new stock level:");
					warehouse.setStockForProductById(id, stock);
					break;
				case EXIT :
					running = false;
					break;
				default :
					System.out.println("Unknown command: " + command);
					break;
			}
		}
		System.out.println("Byebye!");
	}

}
