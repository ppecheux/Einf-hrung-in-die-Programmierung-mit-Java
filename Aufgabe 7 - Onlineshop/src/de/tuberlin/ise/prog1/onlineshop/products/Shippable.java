package de.tuberlin.ise.prog1.onlineshop.products;

import de.tuberlin.ise.prog1.utils.Carrier;
import de.tuberlin.ise.prog1.utils.DeliveryMode;

public interface Shippable {
	
	void ship(String recipient,DeliveryMode deliveryMode,Carrier carrier,int quntity);

}
