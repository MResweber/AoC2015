package aoc2015;

public class DayOne extends Day{

	public DayOne(String inputPath) {
		super(inputPath);
	}

	public void run() {
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
