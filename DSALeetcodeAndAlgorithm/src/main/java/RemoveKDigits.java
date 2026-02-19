package main.java;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="5678";//0001423219";
		int k=3;
		Stack<Character> stack=new Stack<>();
		for(char ch:s.toCharArray()) {
			while(!stack.isEmpty() && stack.peek() >ch && k>0) {//4>2 //2>3 //3>2 //2>1
				stack.pop();//4 poped and 2 added, 3 poped 2 added, 2 popped 1 added now k becomes 0 so omly 1 and 9 added
				k--;
			}
			stack.push(ch);
		}
		while(k-->0 && !stack.isEmpty()) {
			stack.pop();
		}
		StringBuilder result=new StringBuilder();
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		result.reverse();
		int i=0;
		while(i<result.length()&& result.charAt(i)=='0') {
			i++;
		}
		if(result.length()==i) System.out.println(0);
		else System.out.println(result.substring(i));
	}

}
