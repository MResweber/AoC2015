package aoc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class DayThree {

	public void run (String inputPath) {
		File inputFile = new File(inputPath + "-1");
		Scanner inputScanner = null;
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("No input file for day 1");
			System.exit(0);
		}
		String input = inputScanner.nextLine();
		
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		int[] santaPos = {0, 0};
		int[] roboPos = {0, 0};
		int visited = 1;
		
		map.put("0,0", true);
		
		for (int i = 0; i < input.length(); i++) {
			char curChar = input.charAt(i);
			if (i % 2 == 0) {
				visited += move(santaPos, map, curChar);
			}
			else {
				visited += move(roboPos, map, curChar);
			}
		}
		
		System.out.println("Part 1 - Houses Visited: " + visited);
	}
	
	private int move (int[] pos, HashMap<String, Boolean> map, char curChar) {
		if (curChar == '>') pos[0]++;
		if (curChar == '<') pos[0]--;
		if (curChar == '^') pos[1]++;
		if (curChar == 'v') pos[1]--;
		
		String curPos = new Integer(pos[0]).toString() + ',' + new Integer(pos[1]).toString();
		if (map.get(curPos) == null) {
			map.put(curPos, true);
			return 1;
		}
		return 0;
	}
}
