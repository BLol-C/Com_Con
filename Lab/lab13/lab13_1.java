package lab13;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ItemDAO;
import model.Item;

public class lab13_1 {
	public static void main(String[] args) {
		ItemDAO dao = new ItemDAO();
		ArrayList<Item> arr = new ArrayList<Item>();
		Scanner input = new Scanner(System.in);
		String s = "";
		
		while(! s.equals("n")) {
			System.out.print("Enter the name of the item: ");
			String name = input.nextLine();
			System.out.print("Enter the unit price: ");
			double price = input.nextDouble();
			System.out.print("Enter the quantity: ");
			int quantity = input.nextInt();
			
			Item item = new Item(name, price, quantity);
			arr.add(item);
			dao.save(item);
			
			input.nextLine();
			
			System.out.print("Continue shopping (y/n)? ");
			s = input.nextLine();
		}
		
		System.out.println("\nFinal Shopping Cart totals");
		double total = 0;
		for(Item item : arr) {
			System.out.println(item);
			total += item.calTotal();
		}
		System.out.println("Total $ Amount in Cart: $" + total);
		
		
	}
}
