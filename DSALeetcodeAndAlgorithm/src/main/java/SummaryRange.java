package main.java;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0, 1, 2, 4, 5, 5, 7};
		int sum=0, end=arr[0];
		int start=arr[0];
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==sum) {//arr[i]==arr[i - 1] + 1
				end=arr[i];
			} else {
				if(start<end) {
					sb.append(start).append("->").append(end).append(", ");
				} else if(start==end) {
					sb.append(start).append(", ");
				}

				start=arr[i];
				end=arr[i];		
			}
			sum=arr[i]+1;
		}
		if(start<end) {
			sb.append(start).append("->").append(end);
		} else if(start==end) {
			sb.append(start);
		}
		System.out.println(sb.toString());
		
	    int[] nums = {0, 1, 2, 4, 5,5, 7};
	    System.out.println(summaryRanges(nums));
	}



	 public static List<String> summaryRanges(int[] nums) {
	        List<String> result = new ArrayList<>();

	        if (nums == null || nums.length == 0) {
	            return result;
	        }

	        int start = nums[0];

	        for (int i = 1; i <= nums.length; i++) {

	            // break in continuity or end of array
	            if (i == nums.length || nums[i] != nums[i - 1] + 1) {

	                if (start == nums[i - 1]) {
	                    result.add(String.valueOf(start));
	                } else {
	                    result.add(start + "->" + nums[i - 1]);
	                }

	                // start new range
	                if (i < nums.length) {
	                    start = nums[i];
	                }
	            }
	        }
	        return result;
	}

}
