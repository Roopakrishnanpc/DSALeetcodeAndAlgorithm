package main.java;

import java.util.HashSet;
import java.util.Set;

public class TwoSumWith0 {
	public static void main(String[] args) {
		int[] arr= {1, 7, 8, 9, -1, 2};
		Set<Integer> set=new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			int val=-1*arr[i];
			if(set.contains(arr[i])) {
				System.out.println(arr[i]);
				return;
			}
			set.add(val);
		}
		//we can aldo do using Map<Integer, Integer> map.put(val,i)
	}

}
