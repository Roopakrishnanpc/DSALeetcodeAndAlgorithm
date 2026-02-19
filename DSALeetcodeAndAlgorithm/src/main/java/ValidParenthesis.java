package main.java;

import java.util.Stack;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="{}()]";
		Stack<Character> stack=new Stack<>();
		boolean valid=true;
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='[') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty()) { // ✅ check before pop
	                valid = false;
	                break;
	            }
				char c=s.charAt(i);
				char d=stack.pop();
				if((c=='}' && d=='{') || (c==')' && d=='(') || (c==']' && d=='[')) {
					valid=true;
				} else {
					valid=false;
				}
			}
		}
		System.out.println(valid);
	}

}
