package main.java;

public class FindMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,4,-1,1};
		int correctIndex=0;
		for(int i=0; i< arr.length; i++) {
			while(arr[i]>0 && arr[i]<=arr.length && arr[i]!=arr[arr[i]-1]) {
				correctIndex=arr[i]-1;
				swap(arr, i,correctIndex);
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=i+1) {
				System.out.println(i+1);
				return;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
