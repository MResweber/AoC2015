package aoc2015;

public class AoC2015 {

	public static void main (String[] args) {
		String day = args[0];
		String inputPath = "inputs/input" + day;
		Day prog;
		
		switch (day){
			case "1":
				prog = new DayOne(inputPath);
				prog.run();
				break;
			case "2":
				prog = new DayTwo(inputPath);
				prog.run();
				break;
			case "3":
				prog = new DayThree(inputPath);
				prog.run();
				break;
			case "4":
				prog = new DayFour(inputPath);
				prog.run();
				break;
		}
	}
}
