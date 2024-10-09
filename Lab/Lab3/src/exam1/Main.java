package exam1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book();


		Scanner sc = new Scanner(System.in);
		System.out.print("Name : ");
		b1.setName(sc.nextLine());
		System.out.print("Price : ");
		b1.setPrice(sc.nextInt());
		b1.setAuthor("J.K. Rowling");
		b1.setYear(2542);

		System.out.println("Book: " + b1.getName() + "\nWritten by " + b1.getAuthor() + " In " + b1.getYear() + "\nPrice is " + b1.getPrice() + " Bath");

		sc.close();
	}

}
