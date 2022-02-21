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
		HashMap<String, Boolean> map2 = new HashMap<String, Boolean>();
		int[] pos = {0, 0};
		int[] santaPos = {0, 0};
		int[] roboPos = {0, 0};
		int visited = 1;
		int visited2 = 1;
		
		map.put("0,0", true);
		map2.put("0,0", true);
		
		for (int i = 0; i < input.length(); i++) {
			char curChar = input.charAt(i);
			
			visited += move(pos, map, curChar);
			
			if (i % 2 == 0) {
				visited2 += move(santaPos, map2, curChar);
			}
			else {
				visited2 += move(roboPos, map2, curChar);
			}
		}

		System.out.println("Part 1 - Houses Visited: " + visited);
		System.out.println("Part 2 - Houses Visited: " + visited2);
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
