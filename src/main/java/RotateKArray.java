package main.java;

public class RotateKArray {
	public static void main(String[] args) {
		int[] arr= {1,5,7,7,9,3};
		int k=2;// 9 3 1 5 7 7
		k = k % arr.length; 
		swap(arr, 0, arr.length-k-1);// swap(arr, 0,arr.length-1); swap(arr, 0, arr.length-k-1);swap(arr, arr.length-k,arr.length-1);
		swap(arr, arr.length-k,arr.length-1); 
		swap(arr, 0,arr.length-1);
		int[] array= {1,5,7,7,9,3};
		//right swap like 7 7 9 3 1 5
		swap(array, 0, array.length-1);
		swap(array, 0,k-1 );
		swap(array, k,arr.length-1);
		for(int i:arr) {
			System.out.println(i);
		}
		for(int i:array) {
			System.out.println(i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
	
}
