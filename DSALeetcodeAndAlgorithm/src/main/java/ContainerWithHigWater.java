package main.java;

public class ContainerWithHigWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8, 1, 2, 9, 4, 3, 6, 7, 5};
		int left=0, right=arr.length-1;
		int max=0;
		while(left<right) {
			int height=Math.min(arr[left], arr[right]);
			int width=right-left;
			max=Math.max(max, height*width);
			if(arr[left]<arr[right]) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(max);
	}

}
