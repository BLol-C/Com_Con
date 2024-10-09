package lab8.lab8_1.lab7_2;

import lab7.lab7_2.*;

public class Cashier {
	private String name;
	private double balance = 0;

	public Cashier() {

	}

	public Cashier(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printReceipt(InventoryCart cart) {
		Product tmp[] = cart.getAllProduct();
		double balance = 0;

		System.out.println("\t   Pumpkin Shop (" + this.getName() + ")");
		System.out.println("\t============================");

		for (int i = 0; i < tmp.length; i++) {
			int count = 0;
			if (tmp[i] != null) {
				for (int j = i; j < tmp.length; j++) {
					if (tmp[i].equals(tmp[j]) && tmp[j] != null && !tmp[j].isChecked()) {
						tmp[j].setChecked(true);
						count++;
					}
				}
				if (count == 0)
					continue;
				System.out.printf("\t" + count + " x " + tmp[i].toString()
						+ String.format("%-1.0f", tmp[i].getPrice())
						+ "\n");
				balance += tmp[i].getPrice() * count;

			}
		}

		System.out.println("\t============================");
		System.out.println("\t\tTotal\t" + String.format("%.0f", balance) + " $");
	}

	public void doPayment(InventoryCart cart, SavingsAccount.DebitCard card) {
		Product tmp[] = cart.getAllProduct();

		String cardID = card.getCardNumber();
		cardID = cardID.substring(8, 12);

		System.out.println("\t       CARD TYPE:" + card.type());
		System.out.println("\t CARD NUMBER: " + "xxx-xxx-".concat(cardID) + "\n");
		System.out.println("\t\t " + String.format("%-4s", "Pumpkin Shop") + "\n");

		for (int i = 0; i < tmp.length; i++) {
			int count = 0;
			if (tmp[i] != null) {
				for (int j = i; j < tmp.length; j++) {
					if (tmp[i].equals(tmp[j]) && tmp[j] != null && !tmp[j].isChecked()) {
						tmp[j].setChecked(true);
						count++;
					}
				}
				if (count == 0)
					continue;
				System.out.printf("\t" + count + " x " + tmp[i].toString()
						+ String.format("%-1.0f", tmp[i].getPrice())
						+ "\n");
				balance += tmp[i].getPrice() * count;

			}
		}

		System.out.println("\t----------------------------\n");
		if (card.getOwnerAccount().getBalance() < balance) {
			System.out.println("Insufficient Balance.");
		} else {
			System.out.println("\t      CARD DISCOUNT 2.5%\n");
			balance = card.discount() * balance;
			card.withdraw(balance);
		}

		System.out.println("\t\tTotal\t" + String.format("%.1f", balance) + " $");
	}
}
