package main.java;

public class Moves0toLeftand1toRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,0,1,0,1,0,0,1};
		int nonIndex=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {//arr[i]!=0 if 1 to be moved left and 0 to right
				int temp=arr[i];
				arr[i]=arr[nonIndex];
				arr[nonIndex]=temp;
				nonIndex++;
			}
		}
		for(int n:arr) {
			System.out.println(n);
		}
		approach2(arr);
	}

	private static void approach2(int[] arr) {
		// TODO Auto-generated method stub
		int left=0, right=arr.length-1;
		while(left<right) {
			while(left<right && arr[left]==0) left++;
			while(left<right && arr[right]==1) right--;
			if(left<right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		for(int n:arr) {
			System.out.println(n);
		}
	}

}
