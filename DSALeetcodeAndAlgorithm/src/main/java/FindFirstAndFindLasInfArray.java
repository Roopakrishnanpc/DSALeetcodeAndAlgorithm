package main.java;

public class FindFirstAndFindLasInfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,0,0,1,2,4,7,8};
		int target=0;
		int first=findFirstAndLast(arr,true,target);
		int last=findFirstAndLast(arr,false,target);
		
		System.out.println(first +" "+ last);
		
	}

	private static int findFirstAndLast(int[] arr, boolean isFirst, int target) {
		// TODO Auto-generated method stub
		int left=0, right=arr.length-1, ans=0;
		while(left<right) {
			int mid=left+(right-left)/2;
			if(arr[mid]==target) {
				if(isFirst) {
					ans=mid;
					right=mid-1;
				} else {
					ans=mid;
					left=left+1;
				}
			} else if(arr[left]<target) {
				left=left+1;
			} else {
				right=right-1;
			}	
		}
		return ans;
	}

}
