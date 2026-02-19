package main.java;

public class MoveLastZeros {
	public static void main(String[] args) {
		int[] arr= {0, 7, 8, 9, 0, 6, 5, 6, 0, 8, 9};
		int nonIndex=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0) {
				int temp=arr[i];
				arr[i]= arr[nonIndex];
				arr[nonIndex]=temp;
				nonIndex++;
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
