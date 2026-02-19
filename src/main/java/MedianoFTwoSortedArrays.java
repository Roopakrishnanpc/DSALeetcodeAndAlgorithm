package main.java;

public class MedianoFTwoSortedArrays {
	public static void main(String[] args) {
		int[] arr1= {1,2,3,4,5,6,7};
		int[] arr2= {1,2,3,4,5,6,7};
		int total=arr1.length+arr2.length;
		int targetIndex=total/2;
		int left=0, right=0;
		int current=0, previous=0;
		for(int i=0; i<=targetIndex; i++) {
			previous=current;
			if(left<arr1.length &&(right>=arr2.length || arr1[left]<arr2[right])) {
				current=arr1[left++];
			} else {
				current=arr2[right++];
			}
		}
		if(total%2!=0) {
			System.out.println(current);
		} else {
			System.out.println((current+previous)/2);
		}
		//other way merge two arraylist
		//then (merge1[total/2] + merget2[total/2-1)/2;
		//or else median=merge[totalen/2];
		
	}
}
