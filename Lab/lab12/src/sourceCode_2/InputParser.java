package sourceCode_2;

import java.util.ArrayList;

public class InputParser {

	public static ArrayList<Integer> parseInputToList(String input) {

		ArrayList<Integer> list = new ArrayList<>();

		String[] items = input.split(",");

		for (String item : items) {

			list.add(Integer.parseInt(item.trim()));

		}

		return list;

	}

}