package aoc2015;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFive extends Day {

	public DayFive(String inputPath) {
		super(inputPath);
	}

	@Override
	public void run() {
		Pattern vowelPattern = Pattern.compile("[aeiou].*[aeiou].*[aeiou]");
		Pattern exceptPattern = Pattern.compile("ab|cd|pq|xy");
		
		int niceCount = 0;
		int niceCount2 = 0;
		
		while (inputScanner.hasNext()) {
			String input = inputScanner.nextLine();
			Matcher vowelMatcher = vowelPattern.matcher(input);
			Matcher exceptMatcher = exceptPattern.matcher(input);
			
			if (vowelMatcher.find() && repeat(input) && !exceptMatcher.find()) niceCount++;
			
			if (doubleRepeat(input) && splitPair(input)) niceCount2++;
		}
		
		System.out.println("Part 1 - Nice Count: " + niceCount);
		System.out.println("Part 2 - Nice Count: " + niceCount2);
	}

	private boolean repeat (String input) {
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == input.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean doubleRepeat (String input) {
		for (int i = 1; i < input.length(); i++) {
			String checkPair = input.substring(i - 1, i + 1);
			Pattern pairPattern = Pattern.compile(checkPair);
			String restOfString = input.substring(i + 1);
			Matcher pairMatcher = pairPattern.matcher(restOfString);
			if (pairMatcher.find()) return true;
		}
		return false;
	}
	
	private boolean splitPair (String input) {
		for (int i = 2; i < input.length(); i++) {
			if (input.charAt(i - 2) == input.charAt(i)) return true;
		}
		return false;
	}
}
