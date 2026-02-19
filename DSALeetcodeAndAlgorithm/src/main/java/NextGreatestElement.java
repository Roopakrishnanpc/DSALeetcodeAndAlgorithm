package main.java;

import java.util.Stack;

public class NextGreatestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr= {4, 5, 28, 25};
		int[] arr = {6, 5, 4, 7};

		Stack<Integer> stack=new Stack<>();
		int[] result=new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] <arr[i]) {//5>4 //6<5 //6<7
				result[stack.pop()]=arr[i];
				//stack.pop();
			}	
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			result[stack.pop()]=-1;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.println(result[i]);//==0? -1:result[i]);
		}
	}

}
