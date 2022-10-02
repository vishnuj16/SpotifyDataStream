package song_Stream;

import java.util.Random;

public class RandDataGen 
{
	
	public static String randomPhoneno() {
		Random generator = new Random();
		String strippedNum;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		num1 = generator.nextInt(600) + 100;// numbers can't include an 8 or 9, can't go below 100.
		num2 = generator.nextInt(641) + 100;// number has to be less than 742//can't go below 100.
		num3 = generator.nextInt(8999) + 1000; // make numbers 0 through 9 for each digit.//can't go below 1000.

		strippedNum = Integer.toOctalString(num1);

		return strippedNum + "-" + num2 + "-" + num3;
	}

	public static int randIndex(int max)
	{
		Random rand = new Random();
		int rand_int = rand.nextInt(max);
		return rand_int;
	}
	
	public static double getRandDuration() {
		Random r = new Random();
		double randomValue = 90 + (360 - 90) * r.nextDouble();
		return randomValue;
		
	}
}
