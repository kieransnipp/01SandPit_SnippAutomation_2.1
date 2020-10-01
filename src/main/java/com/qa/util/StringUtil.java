package com.qa.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringUtil {

	public static void main(String[] args) {
		findDuplicateWords("  11 22 44 aaa bb aaa aaa v 10 java  nn xxxx 10 xxxx This is a a word word java java 10 ");

	}

	public static int findDuplicateWords(String inputString) {
		// split
		String words[] = inputString.split(" ");

		// create one hash map
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		// To check each word in a given array:
		for (String word : words) {

			// if word is present
			if (word.length() > 1) {

				if (wordCount.containsKey(word)) {
					wordCount.put(word.toLowerCase(), wordCount.get(word) + 1);
				} else {
					wordCount.put(word, 1);
				}
			} // End for
		}

		// Extracting all the keys of the Map - WordCount
		Set<String> wordsInString = wordCount.keySet();
		int count = 0;
		// Loop through all the words in the wordCount
		for (String word : wordsInString) {
			if (wordCount.get(word) > 1) {
				System.out.println("The word '" + word + "', is displayed * " + wordCount.get(word) + " times");
				count ++;
			}

		}
		return count;

	} // End findDuplicateWords

}
