package sourceCode_2;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Set;

public class SetOperations {

	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		Set<Integer> set = new HashSet<>(list1);

		set.addAll(list2);

		return new ArrayList<>(set);

	}

	public static ArrayList<Integer> intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		Set<Integer> set = new HashSet<>(list1);

		set.retainAll(list2);

		return new ArrayList<>(set);

	}

	public static ArrayList<Integer> difference(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		Set<Integer> set = new HashSet<>(list1);

		set.removeAll(list2);

		return new ArrayList<>(set);

	}

}