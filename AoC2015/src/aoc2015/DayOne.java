package aoc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne extends Day{

	public void run(String inputPath) {
		File inputFile = new File(inputPath + "-1");
		Scanner inputScanner = null;
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("No input file for day 1");
			System.exit(0);
		}
		
		int floor = 0;
		String directions = inputScanner.nextLine();
		int pos = 0;

		for (int i = 0; i < directions.length(); i++) {
			char curChar = directions.charAt(i);
			if (curChar == '(') floor++;
			if (curChar == ')') floor--;
			if (pos == 0 && floor < 0) {
				pos = i + 1;
				
			}
		}
		System.out.println("Part 1 - Final Floor: " + floor);
		System.out.println("Part 2 - Basement Positions: " + pos);
	}
}
