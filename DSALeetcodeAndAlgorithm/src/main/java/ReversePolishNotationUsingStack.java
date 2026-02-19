package main.java;

import java.util.Stack;

public class ReversePolishNotationUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s={"2","3","+","3","*"};
		Stack<Integer> stack=new Stack<>();
		for(int i=0; i<s.length; i++) {
			String assignment = s[i];
			if(!isOperator(assignment)) {
				stack.push(Integer.parseInt(s[i]));
			} else {
				int a =stack.pop();
				int b=stack.pop();
				int result=-1;
				switch(assignment) {
				case "+":
					result= (a+b);
					break;
				case "-":
					result= (a-b);
					break;
				case "/":
					result= (a/b);
					break;
				case "*":
					result= (a*b);
					break;
				}
				stack.push(result);
			}
		}
		if(!stack.isEmpty()) {
			System.out.println("Result: " + stack.pop());
		}
	}

	private static boolean isOperator(String assignment) {
		// TODO Auto-generated method stub
		return assignment.equals("+") || assignment.equals("-") || assignment.equals("/") || assignment.equals("*");
	}

}
