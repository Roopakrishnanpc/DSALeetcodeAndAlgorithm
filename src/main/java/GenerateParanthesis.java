package main.java;

public class GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=3;
		
		backtrack("", 0,0,N);
	}

	private static void backtrack(String paranthesis, int i, int j, int n) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		if(paranthesis.length() == 2*n) {
			sb.append(paranthesis);
			System.out.print(paranthesis);
			return;
		}
		if(i<n) {
			backtrack(paranthesis+"(", i+1,j,n);
		}
		if(i>j) {
			backtrack(paranthesis+")",i,j+1,n);
		}
		System.out.println(sb);
	}

}
