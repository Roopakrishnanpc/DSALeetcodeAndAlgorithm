package main.java;


import java.util.Stack;

public class Stack_DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="32[a2[gh]]2[bc]";
		single(s);//works only for this logic
		multiandcorrectone(s);//remember to create Count Stack and StringBuilder and appened all data
	}

	private static void multiandcorrectone(String s) {
		// TODO Auto-generated method stub
		Stack<StringBuilder> sbstack=new Stack<>();
		Stack<Integer> countstack=new Stack<>();
		StringBuilder stringBuilder=new StringBuilder();
		int k=0;
		for(char c:s.toCharArray()) {
			if(Character.isDigit(c)) {
				k = k * 10 + Integer.parseInt(String.valueOf(c));//"2" 3*10+2=32
			} else if(c=='[') {
				sbstack.push(stringBuilder);
				countstack.push(k);
				stringBuilder=new StringBuilder();
				k=0;
			} else if(c==']') {
				int count=countstack.pop();
				StringBuilder temp=sbstack.pop();
				for(int j=1; j<=count;j++) {
					temp.append(stringBuilder);
				}
				stringBuilder=temp;
			} else {
				stringBuilder.append(c);
			}
		}
		System.out.println(stringBuilder.toString());
	}

	private static void single(String s) {
		// TODO Auto-generated method stub
		Stack<Character> stack=new Stack<>();
		
		StringBuilder stringb=new StringBuilder();
		int count=0;
		for(int i=0; i<s.length(); i++) {
			stack.push(s.charAt(i));		
			if(stack.peek()==']') {
				StringBuilder sb=new StringBuilder();
				while(stack.size()>1) {
					if(stack.peek()=='['|| stack.peek()==']') {
						stack.pop();
						continue;
					}
					sb.append(stack.pop());
				}
				sb.reverse();
				count = Character.getNumericValue(stack.pop());

				for(int j=1; j<=count;j++) {
					stringb.append(sb);
				}
			}	
		}
		System.out.println(stringb.toString());
	}
	


}
