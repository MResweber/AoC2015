package aoc2015;

public class AoC2015 {

	public static void main (String[] args) {
		String day = args[0];
		String inputPath = "inputs/input" + day;
		Day prog;
		
		switch (day){
			case "1":
				prog = new DayOne();
				prog.run(inputPath);
				break;
			case "2":
				prog = new DayTwo();
				prog.run(inputPath);
				break;
			case "3":
				prog = new DayThree();
				prog.run(inputPath);
				break;
		}
	}
}
