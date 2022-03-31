package com.spandiar;

import java.util.HashMap;
import java.util.Map;

/*
 * A pangram is a sentence that contains every single letter of the alphabet at least once. 
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, 
 * because it uses the letters A-Z at least once (case is irrelevant). 
 * 
 * Given a string, detect whether or not it is a pangram. Return True if it is, 
 * False if not. Ignore numbers and punctuation.
 * 
 * */

public class Main {
	
	static final String alphabets = "abcdefghijklmnopqrstuvwxyz";
	static final Map<Character, Boolean> resultMap = new HashMap<>();

	public static void main(String[] args) {
		
		String evaluate = "The quick fox also brown, jumps - over 9 the lazy dog";
		boolean result = isPanagram(evaluate);
		
		System.out.println("Result is: " + result);

	}

	private static boolean isPanagram(String sentence) {
		
		if(sentence == null || sentence.length() < 26) {
			return false;
		}
		
		sentence = sentence.toLowerCase();
		char[] sourceToArray = sentence.toCharArray();
		
		for(char character : sourceToArray) {
			
			if(resultMap.size() == 26) {
				break;
			}
			
			if(Character.isLetter(character)) {
					resultMap.put(character, true);
			}
		}
		
		System.out.println("Result Map size is: " + resultMap.size());
		
		if(resultMap.size() < 26) {
			return false;
		}
		
		for(char character : alphabets.toCharArray()) {
			if(!resultMap.get(character)) {
				return false;
			}
		}
		
		return true;
	}

}
