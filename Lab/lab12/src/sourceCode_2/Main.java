package sourceCode_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first list of integers (comma separated): ");

		String input1 = scanner.nextLine();

		ArrayList<Integer> list1 = InputParser.parseInputToList(input1);

		System.out.print("Enter second list of integers (comma separated): ");

		String input2 = scanner.nextLine();

		ArrayList<Integer> list2 = InputParser.parseInputToList(input2);

		System.out.print("Enter the operation (+ for Union, * for Intersection, - for Difference): ");

		String operation = scanner.nextLine();

		ArrayList<Integer> result = new ArrayList<>();

		switch (operation) {

		case "+":

			result = SetOperations.union(list1, list2);

			break;

		case "*":

			result = SetOperations.intersection(list1, list2);

			break;

		case "-":

			result = SetOperations.difference(list1, list2);

			break;

		default:

			System.out.println("Invalid operation!");

			return;

		}

		System.out.println("\nInput: ");

		System.out.println("[" + listToString(list1) + "] " + operation + " [" + listToString(list2) + "]");

		System.out.println("\nOutput: ");

		System.out.println("[" + listToString(result) + "]");

	}

	public static String listToString(ArrayList<Integer> list) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {

			sb.append(list.get(i));

			if (i < list.size() - 1) {

				sb.append(", ");

			}

		}

		return sb.toString();

	}

}