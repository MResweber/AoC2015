package aoc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Day {

	File inputFile;
	Scanner inputScanner;
	
	public Day (String inputPath) {
		inputFile = new File(inputPath);
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("No file at " + inputPath);
			e.printStackTrace();
		}
	}
	
	abstract public void run();
}
