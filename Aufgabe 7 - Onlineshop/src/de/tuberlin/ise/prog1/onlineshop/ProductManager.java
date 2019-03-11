package de.tuberlin.ise.prog1.onlineshop;

import Prog1Tools.IOTools;
import de.tuberlin.ise.prog1.onlineshop.products.Book;
import de.tuberlin.ise.prog1.onlineshop.products.Product;
import de.tuberlin.ise.prog1.onlineshop.products.Television;
import de.tuberlin.ise.prog1.utils.*;

public class ProductManager {
	
	/*
	public static final int LIST = 0;
	public static final int REGISTER = 1;
	public static final int ADJUST_STOCK = 2;
	public static final int EXIT = 3;
*/
	/**
	 * Provides a command line interface to interact with the product management
	 * system for an online shop
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.registerProducts(Warehouse.preloadInitialDataSet());
		System.out.println("Welcome to the online shop product management");
		boolean running = true;
		while (running) {
			System.out.println("Please, enter one of the following commands:" + "\n0 to list all products"
					+ "\n1 to register a new product" + "\n2 to adjust stock levels" +"\n4 for information about shipping"+ "\n3 to exit.");
			int command = IOTools.readInt();
			switch (MenuOption.optionForNumber(command)) {
				case LIST :
					warehouse.printInventory();
					break;
				case REGISTER :
					Product p;
					switch (IOTools.readChar("Do you want to add a book (b) or a television (t)?")) {
						case 'b' :
						case 'B' :
							p = Book.createBookFromUserinput();
							break;
						case 't' :
						case 'T' :
							p = Television.createTelevisionFromUserinput();
							break;
						default :
							continue;
					}
					warehouse.registerProducts(p);
					System.out.println("The following product has been added to the catalog:\n" + p.toString());
					break;
				case ADJUST_STOCK :
					int id = IOTools.readInt("Please, enter product id:");
					int stock = IOTools.readInt("Please, enter new stock level:");
					warehouse.setStockForProductById(id, stock);
					break;
				case EXIT :
					running = false;
					break;
				case SHIP:
					int idn = IOTools.readInt("enter the id of the poduct you want");
					int quantity=IOTools.readInt("enter the quantity of the poduct you want");
					String rec = IOTools.readLine("enter the recipient's name:");
					String ca= IOTools.readLine("enter a carrier between DHL,UPS,FEDEX,HERMES,DPD:");
					String del= IOTools.readLine("enter a delivery mode between STANDARD,EXPRESS,OVERNIGHT,LOW_COST:");
					warehouse.getWarehouseItemByProductId(idn).ship(rec, DeliveryMode.read(del),Carrier.read(ca), quantity);
					
					break;
				default :
					System.out.println("Unknown command: " + command);
					break;
			}
		}
		System.out.println("Byebye!");
	}

}
