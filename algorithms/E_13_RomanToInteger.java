package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//https://leetcode.com/problems/roman-to-integer/
public class E_13_RomanToInteger {
	
	
	
 public int romanToInt_1(String s) {
	 
	 int arr[] = new int[s.length()];
	 
	 for(int i=0;i<s.length();i++){
		 switch(s.charAt(i)){
		 case 'M':
			 arr[i] = 1000;
			 break;
		 case 'D':
			 arr[i] = 500;
			 break;
		 case 'C':
			 arr[i] = 100;
			 break;
		 case 'L':
			 arr[i] = 50;
			 break;
		 case 'X':
			 arr[i] = 10;
			 break;
		 case 'V':
			 arr[i] = 5;
			 break;	 
		 case 'I':
			 arr[i] = 1;
			 break;

			 
		 
		 }
	 }
	 int result=0;
	 for(int i=0;i<arr.length-1;i++){
		 
		 if(arr[i] < arr[i+1])
			 result -= arr[i];
		 else
			 result +=arr[i];
		 
	 }
	 
	 return result + arr[arr.length - 1];
	 
 }
	
	
	 public int romanToInt(String s) {
		 
		 s = updateInput(s);
		 
		 Map<Character, Integer> romanMap = buildMap();
		 int result = 0;
		 for(char c:s.toCharArray()){
			 result = result + Integer.parseInt(romanMap.get(c)+"");
		 }
		 
	        return result;
	    }
	
	
	private String updateInput(String s) {
		s = s.replaceAll("IV", "a");
		s = s.replaceAll("IX", "b");
		s = s.replaceAll("XL", "c");
		s = s.replaceAll("XC", "d");
		s = s.replaceAll("CD", "e");
		s = s.replaceAll("CM", "f");
		
		
		return s;
	}


	private Map<Character, Integer> buildMap() {
		Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		romanMap.put('a', 4);
		romanMap.put('b', 9);
		romanMap.put('c', 40);
		romanMap.put('d', 90);
		romanMap.put('e', 400);
		romanMap.put('f', 900);
	
	
		
		
		return romanMap;
	}


	public static void main(String[] args) {

	}
	
	E_13_RomanToInteger obj;
	@Before
	public void setUp(){
		obj = new E_13_RomanToInteger();
	}
	
	@Test
	public void test1(){
		int result = obj.romanToInt("I");
		Assert.assertEquals(1, result);
	}
	@Test
	public void test2(){
		int result = obj.romanToInt("III");
		Assert.assertEquals(3, result);
	}
	@Test
	public void test3(){
		int result = obj.romanToInt("IV");
		Assert.assertEquals(4, result);
	}
	@Test
	public void test4(){
		int result = obj.romanToInt("IX");
		Assert.assertEquals(9, result);
	}
	@Test
	public void test5(){
		int result = obj.romanToInt("LVIII");
		Assert.assertEquals(58, result);
	}
	@Test
	public void test6(){
		int result = obj.romanToInt_1("MCMXCIV");
		Assert.assertEquals(1994, result);
	}
	@Test
	public void test7(){
		int result = obj.romanToInt("CM");
		Assert.assertEquals(900, result);
	}
}
