package main.java;

public class SearchInSortedArray {
	public static void main(String[] args) {
		int[] arr= {3, 4, 5, 6, 7, 8, 9};
		int target=9;
		int left=0, right=arr.length-1;
		while(left<=right) {
			int mid=left + (right-left)/2;
			if(arr[mid]==target) {
				System.out.print(mid);
				return;
			} else if (arr[mid] > target) {
				right = mid-1;
			} else {
				left=mid+1;
			}
		}
	}

}
