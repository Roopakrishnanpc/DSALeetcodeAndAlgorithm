package main.java;

public class NumSubArrayWithProductLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,5,2,6};
		int k=100;
		int product=1;
		int start=0;
		int result=0;
		for(int end=0; end<arr.length; end++) {
			product*=arr[end];
			while(product>=k) {
				product=product/arr[start];
				start++;
			}
			result+=end-start+1;
		}
		System.out.println(result);
	}

}
