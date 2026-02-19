package main.java;

public class FindMinInSortedRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,6,7,1,2,3};
		int left=0, right=arr.length-1;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(arr[mid]>arr[right]) {
				left=mid+1;
			} else {
				right=mid;
			}
		}
		System.out.println(arr[left]);
		
	}

}
