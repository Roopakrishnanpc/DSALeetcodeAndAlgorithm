package main.java;

import java.util.HashSet;
import java.util.Set;

public class findDuplicateNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,3,4,5,5,5,5,2,2,2};
		Set<Integer> set= new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			int index=Math.abs(arr[i])-1;
			if(arr[index]<0) {
				set.add(Math.abs(arr[i]));
			} else {
				arr[index]=-arr[index];
			}
		}
		System.out.println(set);
	}

}
