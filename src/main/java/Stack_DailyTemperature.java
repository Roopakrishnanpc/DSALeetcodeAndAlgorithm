package main.java;

import java.util.Stack;

public class Stack_DailyTemperature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {73,74,75,71,69,72,76,73};
		Stack<Integer> stack=new Stack<>();
		int[] result=new int[arr.length];
		for(int i=0; i< arr.length; i++) {
			while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]) {
				int index=stack.pop();
				result[index]=i-index;
			}
			stack.push(i);
		}
		for(int r:result) {
			System.out.println(r);
		}
	}

}
