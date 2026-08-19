package collections_generics;

public class ShoppingBasketItem {
	String productName;
	int quantity;
	double price;
	
	ShoppingBasketItem(String productName, int quantity,	double price) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getDetails() {
		String output = String.format("Product: %s, Quantity: $d, Cost: $d", productName, quantity, price);
		return output;
	}
}
