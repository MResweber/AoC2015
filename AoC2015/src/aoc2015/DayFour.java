package aoc2015;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFour extends Day {

	public DayFour(String inputPath) {
		super(inputPath);
	}

	@Override
	public void run() {
		String input = inputScanner.nextLine();
		boolean found = false;
		boolean found2 = false;
		int num = 0;
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		while (!found || !found2) {
			String key = input + num;
			byte[] thing = md.digest(key.getBytes());
			BigInteger number = new BigInteger(1, thing);
			String result = number.toString(16);
			while (result.length() < 32) {
				result = "0" + result;
			}
			
			if (result.substring(0, 5).equals("00000")) {
				if (!found) System.out.println("Part 1 - Num: " + num);
				found = true;
			}
			
			if (result.substring(0, 6).equals("000000")) {
				System.out.println("Part 2 - Num: " + num);
				found2 = true;
			}
			num++;
		}
	}

}
