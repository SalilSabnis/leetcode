package leetcode.algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/solution/
public class E_20_ValidParentheses {
	public static boolean isValid(String s) {

		List<Character> openBraces = Arrays.asList('{', '(', '[');
		List<Character> closedBraces = Arrays.asList('}', ')', ']');
		Stack<Character> stack = new Stack<Character>();
		for (Character element : s.toCharArray()) {

			if (openBraces.contains(element)) {
				stack.push(element);
			} else if (closedBraces.contains(element) && !stack.isEmpty()) {
				Character elementOnStack = stack.peek();
				int index1 = openBraces.indexOf(elementOnStack);
				int index2 = closedBraces.indexOf(element);
				if (index1 == index2) {
					stack.pop();
				} else {
					stack.push(element);
				}

			}
			 else {
					stack.push(element);
				}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("(])"));
	}
}
