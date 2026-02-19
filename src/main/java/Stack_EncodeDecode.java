package main.java;

import java.util.Stack;

public class Stack_EncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String password="aaabbc";
			int count=1;
			Stack<Character> stack=new Stack<>();
			StringBuilder stringBuilder=new StringBuilder();
			for(int i=0; i<password.length(); i++) {
				char c=password.charAt(i);
				if(!stack.isEmpty() && stack.peek()==c) {
					count++;
				} else {
					if(!stack.isEmpty()) {
						char ch=stack.pop();
						stringBuilder.append(ch).append(count);
					}
					stack.push(c);
					count=1;
				}
			}
			if(!stack.isEmpty()) {
				char ch=stack.pop();
				stringBuilder.append(ch).append(count);
			}
			System.out.print(stringBuilder.toString());
	}

}
