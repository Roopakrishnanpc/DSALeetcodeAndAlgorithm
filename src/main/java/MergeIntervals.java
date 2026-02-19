package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr= {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
		Arrays.sort(arr,(a,b)-> Integer.compare(a[0], b[0]));
		List<int[]> list=new ArrayList<>();
		int[] curr=arr[0];//1,3
		for(int i=1; i<arr.length; i++) {
			int[] second=arr[i];//arr[i] i as 1 is =2,6 if we neeed second[0] then 2 second[1] then 6
			if(curr[1]>=second[0]) {//arr[i][0] for second[0] -> 3>=2
				curr[1]=Math.max(curr[1], second[1]);//arr[i][1]) for second[1]
				//3=Math.max(3,6) so curr 1 becomes 6 {1,6}
			} else{
				list.add(curr);
				curr=second;
			}
		}
		 list.add(curr);
		 for(int[] num:list) {
			 System.out.println(Arrays.toString(num));
		 }
	}
}
