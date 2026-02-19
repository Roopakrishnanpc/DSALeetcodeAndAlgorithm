package main.java;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 2, 2, 3, 4, 2};// {4, 5, 6, 7, 1, 2, 3}
		int target = 2;
		int left=0, right=arr.length-1;
		while(left<=right) {
			int mid=left + (right-left)/2;
			if(arr[mid]==target) {
				System.out.print(mid);
				return;
			} 
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
                continue;
            }
			if(arr[mid]>=arr[left]) { //7>=4
				if(arr[mid]>target && arr[left]<=target) {//7>6 && 4<=6
					right=mid-1;
				} else {//7<6 && 4<6
					left=mid+1;
				}
			} else {
				if(arr[mid]<target && arr[right]>=target) {//5<6 && 6>=6
					left=mid+1;
				} else {
					right=mid-1;
				}
			}

		}
	}
}
