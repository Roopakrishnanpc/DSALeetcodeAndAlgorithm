package main.java;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraywithSumEqualTarget {
	public static void main(String[] args) {
		int[] arr= {5,6,4,1, -1, 5, -4,-2, 3};
		int target= 3;
		int sum=0;
		int maxLength=0;
		//Longest subarray with sum = target
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0,-1);
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
			if(sum==target)
				maxLength=i+1;
			if(!map.containsKey(sum)) map.put(sum,i);
			if(map.containsKey(sum-target))//see this mainly means if my sum is already present or not
				//if present lets say 5 is present for previous
				//then if we do sum-=arr[i] or prefixSum we can get the target 
				//5,5 
				//i=0 sum=5, map.put(5,0)
				//i=1 sum +=arr[i] = 10 not added into map sum-target= 10-5=5 
				//5 is present map.get(5) = 0-> i-0=1-0=1
				//maxlength becomes 1
				maxLength = Math.max(maxLength, i - map.get(sum - target));//LETS SAY I IS 6 and map.get is 0 then length is 6
		}
		System.out.println(maxLength);
		//Minimum length subarray with sum = target
		sum = 0;
		map.clear();
	        int minLength = Integer.MAX_VALUE;
	        map.put(0, -1); // base case

	        for (int i = 0; i < arr.length; i++) {
	            sum += arr[i];
				 // not required
				 if(sum==target) minLength=i+1;
				 
	            if (map.containsKey(sum - target)) {
	                minLength = Math.min(minLength, i - map.get(sum - target));
	            }

	            // IMPORTANT for minimum length → always update
	            map.put(sum, i);
	        }

	        System.out.println(
	            minLength == Integer.MAX_VALUE ? 0 : minLength
	        );
	        //Count of subarrays with sum = target
	     map.clear();
	     sum=0;
	     int count=0;
	     map.put(0, 1);
	     for(int num:arr) {
	    	 sum+=num;
	    	// 1️ Count valid subarrays ending here
	    	 count += map.getOrDefault(sum - target, 0);

	    	 // 2️ Store current prefix sum
	    	 map.put(sum, map.getOrDefault(sum, 0) + 1);
	     }
	     System.out.println(count);
	}
}
