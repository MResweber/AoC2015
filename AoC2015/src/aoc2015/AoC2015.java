package aoc2015;

public class AoC2015 {

	public static void main (String[] args) {
		String day = args[0];
		String inputPath = "inputs/input" + day;
		
		switch (day){
			case "1":
				DayOne one = new DayOne();
				one.run(inputPath);
				break;
			case "2":
				DayTwo two = new DayTwo();
				two.run(inputPath);
				break;
			case "3":
				DayThree three = new DayThree();
				three.run(inputPath);
				break;
		}
	}
}
