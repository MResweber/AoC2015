package aoc2015;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DaySix extends Day {
	
	public DaySix(String inputPath) {
		super(inputPath);
	}

	
	private int[] parsePos(String pos) {
		String[] split = pos.split(",");
		int[] posArray = {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
		return posArray;
	}
	
	@Override
	public void run() {
		Grid grid = new Grid();
		Grid2 grid2 = new Grid2();
		
		while (inputScanner.hasNextLine()) {
			String input = inputScanner.nextLine();
			Pattern numPattern = Pattern.compile("[0-9]*,[0-9]*");
			Matcher  numMatcher = numPattern.matcher(input);
			numMatcher.find();
			int[] pos1 = parsePos(numMatcher.group());
			numMatcher.find(input.indexOf("through"));
			int[] pos2 = parsePos(numMatcher.group());
			
			Pattern onPattern = Pattern.compile("turn on");
			Matcher onMatcher = onPattern.matcher(input);
			
			Pattern offPattern = Pattern.compile("turn off");
			Matcher offMatcher = offPattern.matcher(input);
			
			Pattern togglePattern = Pattern.compile("toggle");
			Matcher toggleMatcher = togglePattern.matcher(input);
			
			if (onMatcher.find()) {
				grid.turnOn(pos1, pos2);
				grid2.turnOn(pos1, pos2);
			}
			else if (offMatcher.find()) {
				grid.turnOff(pos1, pos2);
				grid2.turnOff(pos1, pos2);
			}
			else if (toggleMatcher.find()) {
				grid.toggle(pos1, pos2);
				grid2.toggle(pos1, pos2);
			}
		}
		System.out.println("Part 1 - On Lights: " + grid.getOnLights());
		System.out.println("Part 2 - Total Brightness: " + grid2.getTotalBrightness());
	}

	private class Grid {
		boolean[][] lightArray;
		int onLights;
		
		private Grid() {
			onLights = 0;
			lightArray = new boolean[1000][1000];
			for (int i = 0; i < lightArray.length; i++) {
				for (int j = 0; j < lightArray[i].length; j++) {
					lightArray[i][j] = false;
				}
			}
		}
		
		private void turnOn(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					if (!lightArray[i][j]) onLights++;
					lightArray[i][j] = true;
				}
			}
		}
		
		private void turnOff(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					if (lightArray[i][j]) onLights--;
					lightArray[i][j] = false;
				}
			}
		}
		
		private void toggle(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					if (lightArray[i][j]) {
						lightArray[i][j] = false;
						onLights--;
					}
					else {
						lightArray[i][j] = true;
						onLights++;
					}
				}
			}
		}
		
		private int getOnLights () {
			return onLights;
		}
	}

	private class Grid2 {
		int[][] lightArray;
		int totalBrightness;
		
		private Grid2() {
			totalBrightness = 0;
			lightArray = new int[1000][1000];
			for (int i = 0; i < lightArray.length; i++) {
				for (int j = 0; j < lightArray[i].length; j++) {
					lightArray[i][j] = 0;
				}
			}
		}
		
		private void turnOn(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					lightArray[i][j]++;
					totalBrightness++;
				}
			}
		}
		
		private void turnOff(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					if (lightArray[i][j] != 0) {
						lightArray[i][j]--;
						totalBrightness--;
					}
				}
			}
		}
		
		private void toggle(int[] pos1, int[] pos2) {
			for (int i = pos1[0]; i <= pos2[0]; i++) {
				for (int j = pos1[1]; j <= pos2[1]; j++) {
					lightArray[i][j] += 2;
					totalBrightness += 2;
				}
			}
		}
		
		private int getTotalBrightness () {
			return totalBrightness;
		}
	}
}