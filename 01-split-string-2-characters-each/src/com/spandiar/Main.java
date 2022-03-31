package com.spandiar;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Given a string, split it into an array of 2 char each
 * If the length is not even, append an underscore
 * */

public class Main {

	public static void main(String[] args) {
		
		String evaluate = "fksajhfbsa2jwfsja";
		String[] result = solution(evaluate);
		System.out.println("Result is: " + Arrays.toString(result));

	}

	private static String[] solution(String evaluate) {
		
		String[] result = new String[evaluate.length()/2 + 1];
		int counter = 0;
		
		if(evaluate.length() % 2 == 1) {
			evaluate = evaluate.concat("_");
		}
		
		Pattern pattern = Pattern.compile("(\\w{2})");
		Matcher matcher = pattern.matcher(evaluate);
		
		while(matcher.find()) {
			result[counter] = matcher.group(1);
			counter++;
		}
		
		return result;
	}

}
