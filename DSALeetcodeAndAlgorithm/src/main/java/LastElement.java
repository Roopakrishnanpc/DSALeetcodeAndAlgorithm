package main.java;

public class LastElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input1=5;
		int input2=3;
		if(input1<1 || input2>input1) {
			System.out.println(false);
			return;
		}
		//nCr = n! / (r! * (n-r)!)
		int result=1;//or long
		int min=Math.min(input2-1, input1-input2);
		for(int i=1; i<min; i++) {
			result=result*(input1-i)/i;
		}
		System.out.println(result);
	}

}
