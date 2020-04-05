package leetcode.algorithms;

//https://leetcode.com/problems/reverse-integer/
public class E_7_ReverseNumber {
	public static int reverse(int x) {

		long revNumber = 0;
		
		while(x !=0){
			
			revNumber = revNumber*10 + x%10;
			if(revNumber >Integer.MAX_VALUE || revNumber<Integer.MIN_VALUE)
				return 0;
			x = x/10;
			
		}
			return (int)revNumber;
	}
	
	
	/*
	 * However, this approach is dangerous, because the statement \text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop can cause overflow.

Luckily, it is easy to check beforehand whether or this statement would cause an overflow.

To explain, lets assume that \text{rev}rev is positive.

If temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop causes overflow, then it must be that \text{rev} \geq \frac{INTMAX}{10}rev≥ 
10
INTMAX
​	
 
If \text{rev} > \frac{INTMAX}{10}rev> 
10
INTMAX
​	
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop is guaranteed to overflow.
If \text{rev} == \frac{INTMAX}{10}rev== 
10
INTMAX
​	
 , then temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop will overflow if and only if \text{pop} > 7pop>7
Similar logic can be applied when \text{rev}rev is negative.
	 */
	
	    public int reverse_2(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(121));
		System.out.println(reverse(-1189));
		System.out.println(reverse(1));
		System.out.println(reverse(0));
		System.out.println(reverse(1534236469));
		System.out.println(reverse(-2147483648));
		System.out.println(Integer.MAX_VALUE);
	//	int x=9646324351;
	
	}
}
