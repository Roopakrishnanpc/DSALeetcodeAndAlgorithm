package main.java;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {100,4,200,1,3,2,1};
		Set<Integer> set=new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		int start=0,length=0,curr=0;int maxLength=0;;
		for(int i=0; i<arr.length; i++) {
			start=arr[i];
			
			if (!set.contains(start - 1)) {
				
			    curr = start;
			    length = 1;
			    while(set.contains(curr + 1)) {
			        curr += 1;
			        length += 1;
			    }
			    maxLength = Math.max(maxLength, length);
			}

		}
		
		System.out.println(maxLength);
	}

}
