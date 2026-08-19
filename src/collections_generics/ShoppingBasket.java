package collections_generics;

import java.util.ArrayList;

public class ShoppingBasket {
	ArrayList<ShoppingBasketItem> shoppingBasketItem = new ArrayList<ShoppingBasketItem>();
	
	void add(ShoppingBasketItem item) {
		shoppingBasketItem.add(item);
	}
}
