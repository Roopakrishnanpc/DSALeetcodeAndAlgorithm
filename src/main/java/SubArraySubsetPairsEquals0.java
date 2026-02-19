package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class SubArraySubsetPairsEquals0 {
	public static void main(String[] args) {
		int[] arr= {4,3,1,-1};
		subArray(arr);
		subset(arr);
		Pairs(arr);
	}

	private static void Pairs(int[] arr) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			if(set.contains(arr[i])) {
				System.out.println(true);
				return;
			}
			set.add(-(arr[i]));
		}
	}

	private static void subset(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> subset = new ArrayList<>();
		int sum=0;
		if(hassubset(arr,0,sum,subset)) {
			System.out.println(subset);
		}else {
			System.out.println(false);
		}
	}

	private static boolean hassubset(int[] arr, int i, int sum, List<Integer> set) {
		// TODO Auto-generated method stub
		if(i ==arr.length) {
			return sum==0;
		}
		set.add(arr[i]);
		if(hassubset(arr,i+1,sum+arr[i],set)) {
			return true;
		}
		set.remove(set.size()-1);
		if(hassubset(arr,i+1,sum,set)) {
			return true;
		}
		return false;
	}

	private static void subArray(int[] arr) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<>();
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
			if(set.contains(sum) || sum==0) {
				System.out.println(true);
				return;
			}
			set.add(sum);
		}
		sum=0;
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0, -1);
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
			if(map.containsKey(sum)) {
				System.out.println(true);
				int k=map.get(sum);
				for(int j=k+1; j<i; j++ ) {
					System.out.println(arr[j] +" ");
				}
			}
			map.put(sum, i);
		}
	}
}
