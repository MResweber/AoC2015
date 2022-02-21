package aoc2015;

public class DayTwo extends Day{

	public DayTwo(String inputPath) {
		super(inputPath);
	}

	public void run () {
		int totalPaper = 0;
		int totalRibbon = 0;
		while (inputScanner.hasNext()) {
			 String curLine = inputScanner.nextLine();
			 String[] splitLine = curLine.split("x");
			 int l = new Integer(splitLine[0]);
			 int w = new Integer(splitLine[1]);
			 int h = new Integer(splitLine[2]);
			 
			 int sideA = l * w;
			 int sideB = w * h;
			 int sideC = l * h;
			 int bow = l * w * h;
			 int shortSide = 0;
			 int ribbon = 0;
			 
			 if (l >= w && l >= h) {
				 shortSide = sideB;
				 ribbon = w *2 + h * 2;
			 }
			 else if (w >= l && w >= h) {
				 shortSide = sideC;
				 ribbon = l *2 + h * 2;
			 }
			 else if (h >= l && h >= w) {
				 shortSide = sideA;
				 ribbon = l *2 + w * 2;
			 }
			 
			 totalPaper += sideA * 2 + sideB * 2 + sideC * 2 + shortSide;
			 totalRibbon += ribbon + bow;
		}
		System.out.println("Part 1 - Total Wrapping Paper Needed = " + totalPaper + " sq. ft.");
		System.out.println("Part 2 - Total Ribbon Needed = " + totalRibbon + " ft.");
	}
}
