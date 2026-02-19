package main.java;

public class ProductOfArrayExceptItself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,4,5};
		int product=1;
		int result[] =new int[arr.length];
		result[0]=1;
		for(int i=1; i<arr.length; i++) {
			result[i]=result[i-1]*arr[i-1];
			System.out.println(result[i]);
		}
		for(int i=arr.length-1; i>=0; i--) {
			result[i]*=product;
			System.out.println(arr[i]);
			product*=arr[i];
			System.out.println(product);
		}
		for(int num:result) {
			System.out.println(num);
		}
	}

}
