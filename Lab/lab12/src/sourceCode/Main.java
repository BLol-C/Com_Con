package sourceCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList items = new ArrayList();
		String s;
		String continueShop;
		float p;
		int quan;
		float amount = 0;
		
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.print("Enter the name of the item : ");
			s = sc.nextLine();
			
			System.out.print("Enter the unit price: ");
			p = sc.nextFloat();
			
			System.out.print("Enter the quantity: ");
			quan = sc.nextInt();
			
			items.add(new Item(s,p,quan));
			
			System.out.println("Continue shopping (y/n)? ");
			continueShop = sc.next();
			sc.nextLine();
		
			
			} while (continueShop.equalsIgnoreCase("y"));
		System.out.println("Final Shopping Cart totals");
		for(int i = 0; i < items.size();i++) {
			Item item = (Item) items.get(i);
			System.out.print(item);
			amount += item.getAmount();
		}
		System.out.printf("Total $ Amount in Cart: %.2f ",amount);

		
	}

}
