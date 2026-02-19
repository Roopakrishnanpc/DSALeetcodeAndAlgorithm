package main.java;

public class MaximumProductSubArrayKadanesAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {-4,-5,-6,8,9,1};
		int product=arr[0];
		int maxProduct=arr[0];
		int minProduct=arr[0];
		for(int i=1; i<arr.length; i++) {
			int tempmaxProduct=Math.max(arr[i], Math.max(maxProduct*arr[i], minProduct*arr[i]));
			int tempminProduct=Math.min(arr[i],Math.min(maxProduct* arr[i], minProduct*arr[i]));
			maxProduct=tempmaxProduct;
			minProduct=tempminProduct;
			product=Math.max(maxProduct, product);
		}
		System.out.println(product);
	}

}
