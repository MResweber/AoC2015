package aoc2015;

public class AoC2015 {

	public static void main (String[] args) {
		String day = args[0];
		String inputPath = "inputs/input" + day;
		
		switch (day){
			case "1":
				DayOne d = new DayOne();
				d.run(inputPath);
				break;
		}
	}
}
