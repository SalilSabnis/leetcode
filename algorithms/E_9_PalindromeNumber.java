package leetcode.algorithms;

//https://leetcode.com/problems/palindrome-number/
public class E_9_PalindromeNumber {
	public static boolean isPalindrome(int x) {
		
		int num = x;
		String rev="";
		while(num != 0 && num>0){
			rev = rev + (num%10);
			num = num/10;
			
		}
		System.out.println(rev);
		
		return (x+"").equals(rev);
	}
	
	
//Revert half of the int number and compare it with the other half
	/*
	 * Algorithm

First of all we should take care of some edge cases. All negative numbers are not palindrome, for example: -123 is not a palindrome since the '-' does not equal to '3'. So we can return false for all negative numbers.

Now let's think about how to revert the last half of the number. For number 1221, if we do 1221 % 10, we get the last digit 1, to get the second to the last digit, we need to remove the last digit from 1221, we could do so by dividing it by 10, 1221 / 10 = 122. Then we can get the last digit again by doing a modulus by 10, 122 % 10 = 2, and if we multiply the last digit by 10 and add the second last digit, 1 * 10 + 2 = 12, it gives us the reverted number we want. Continuing this process would give us the reverted number with more digits.

Now the question is, how do we know that we've reached the half of the number?

Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is less than the reversed number, it means we've processed half of the number digits.
	 */
public static boolean isPalindrome_2(int x) {
	
	if( x<0 || (x%10==0&&x!=0))
		return false;
	
	int revNumber = 0;
	
	while(x > revNumber){
		
		revNumber = revNumber*10 + x%10;
		x = x/10;
		
	}
	
	
	
	return x == revNumber || x == revNumber/10;
}

	public static void main(String[] args) {
//		System.out.println(isPalindrome(129));
		System.out.println(isPalindrome_2(-1));
//		System.out.println(isPalindrome(3));
	}
}
