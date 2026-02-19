package main.java;

public class SortColours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,2,1,0,0,1,2};
		int mid=0, left=0, right=arr.length-1;
		while(mid<=right) {
			if(arr[mid]==0) {
				int temp=arr[mid];
				arr[mid]=arr[left];
				arr[left]=temp;
				left++;
				mid++;
			} else if(arr[mid]==1) {
				mid++;
			} else {
				int temp=arr[mid];
				arr[mid]=arr[right];
				arr[right]=temp;
				right--;
			}
		}
		for(int num:arr) {
			System.out.print(num +" ");
		}
	}

}
