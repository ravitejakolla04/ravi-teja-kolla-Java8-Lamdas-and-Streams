package com.epam.java_lambda_streams;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App implements Palin {
	public void PalindromeList(List<String> list, Predicate<String> predicate) {
		for (String s : list) {
			if (predicate.test(s)) {
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buffer_reader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		Average average_object = new Average();
		App app = new App();
		StringFilter stringFilter_object = new StringFilter();
		while (flag) {
			System.out.println("Press 1: Average of n numbers");
			System.out.println("Press 2: Checks the strings starts with 'a' and length 3");
			System.out.println("Press 3: Checks the strings are palindrome");
			int choice = Integer.parseInt(buffer_reader.readLine());
			if (choice == 1) {
				System.out.println("Enter n numbers seperated by space: ");
				String[] average_input = buffer_reader.readLine().split(" ");
				List<Integer> avg_input_list = new ArrayList<>();
				for (String s : average_input)
					avg_input_list.add(Integer.parseInt(s));
				System.out.println(average_object.findAverage(avg_input_list));
			} else if (choice == 2) {
				System.out.println("Enter the strings seperated by space: ");
				String[] filter_input = buffer_reader.readLine().split(" ");
				List<String> filtered_list = stringFilter_object.filterStrings(Arrays.asList(filter_input));
				for (String s : filtered_list)
					System.out.print(s + " ");
				System.out.println();
			} else if (choice == 3) {
				System.out.println("Enter the strings separated by space: ");
				String[] palindrome_input = buffer_reader.readLine().split(" ");
				app.PalindromeList(Arrays.asList(palindrome_input),
						(s) -> s.equals(new StringBuilder(s).reverse().toString()));
			} else {
				flag = false;
				return;
			}
		}
	}
}