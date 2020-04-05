package leetcode.algorithms;


//https://leetcode.com/problems/string-to-integer-atoi/
import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;
public class M_8_StringToInteger {

	public static int myAtoi(String str) {
		
		if (null==str || str.isEmpty() || str.equals("-") || str.contains("+-")
				|| str.contains("-+") || str.trim().length()==0)
			return 0;

		while (str.startsWith(" "))
			str = str.replaceFirst(" ", "");

		boolean negativeNumber = false;

		
		if (str.charAt(0) == '+') {
			str = str.replaceFirst("\\+", "");
		}

		if (str.isEmpty())
			return 0;

		if (str.charAt(0) == '-') {
			negativeNumber = true;
			str = str.replaceFirst("-", "");
		}
		if ((int) str.charAt(0) < 48 || (int) str.charAt(0) > 57) {
			return 0;
		}

		String toConvert = "";
		for (char c : str.toCharArray()) {
			if ((int) c > 47 && (int) c < 58) {
				toConvert = toConvert + c;
			} else
				break;
		}

		if (negativeNumber) {
			toConvert = "-" + toConvert;
		}

		BigInteger number = new BigInteger(toConvert);

		int result = 0;
		if (number.compareTo(new BigInteger(Integer.MAX_VALUE + "")) > 0
				|| number.compareTo(new BigInteger(Integer.MIN_VALUE + "")) < 0) {
			if (negativeNumber)
				result = Integer.MIN_VALUE;
			else
				result = Integer.MAX_VALUE;

		}
		else{
			result = number.intValue();
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("123cd"));
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("91283472332"));
		System.out.println(myAtoi(""));
		System.out.println(myAtoi("-"));
		System.out.println(myAtoi("+1"));
		System.out.println(myAtoi("+-2"));
		System.out.println(myAtoi("+"));
		System.out.println(myAtoi("   +0 123"));
		System.out.println(myAtoi("20000000000000000000"));
	}
	
	@Test
	public void test1(){
		Assert.assertEquals(123, myAtoi("123cd"));
		Assert.assertEquals(0, myAtoi("+"));
		Assert.assertEquals(0, myAtoi("-"));
		Assert.assertEquals(0, myAtoi("   +0 123"));
		Assert.assertEquals(0, myAtoi("-+213"));
		Assert.assertEquals(1, myAtoi("+1"));
		Assert.assertEquals(-13, myAtoi("-13+8"));
		Assert.assertEquals(0, myAtoi(""));
		Assert.assertEquals(0, myAtoi(" "));
		Assert.assertEquals(0, myAtoi("    "));
		Assert.assertEquals(0, myAtoi(null));
		Assert.assertEquals(0, myAtoi("--2"));
	}
}
