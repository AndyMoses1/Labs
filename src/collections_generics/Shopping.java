package collections_generics;

import java.util.LinkedList;
import java.util.Queue;

public class Shopping {

	private static Queue<ShoppingBasket> baskets = new LinkedList<ShoppingBasket>();

	public static void main(String[] args) {
		ShoppingBasket basket1 = new ShoppingBasket();
		basket1.add(new ShoppingBasketItem("Bread", 2, 1.20));
		basket1.add(new ShoppingBasketItem("Milk", 1, 0.95));

		ShoppingBasket basket2 = new ShoppingBasket();
		basket2.add(new ShoppingBasketItem("Apples", 6, 0.35));
		basket2.add(new ShoppingBasketItem("Oranges", 4, 0.75));

		ShoppingBasket basket3 = new ShoppingBasket();
		basket3.add(new ShoppingBasketItem("Coffee", 1, 4.50));
		basket3.add(new ShoppingBasketItem("Sugar", 2, 0.80));
		basket3.add(new ShoppingBasketItem("Pasta", 1, 2.25));

		// offer() adds to the tail of the queue.
		baskets.offer(basket1);
		baskets.offer(basket2);
		baskets.offer(basket3);

		System.out.println("Baskets in the queue: " + baskets.size());

		processBaskets();
	}
	
	public static void processBaskets() {
		
		while (!baskets.isEmpty()) {
			// each basket is ShoppingBasket
			ShoppingBasket basket = baskets.poll();
			double totalCost = 0;

			//each basket has ShoppingBasketItem in it - need to use that in the for loop
			//"items" == basket.shoppingBasketItem
			for (ShoppingBasketItem item : basket.shoppingBasketItem) {
				totalCost += item.quantity * item.price;
			}

			System.out.printf("Basket total: %.2f%n", totalCost);
		}
	}
}
