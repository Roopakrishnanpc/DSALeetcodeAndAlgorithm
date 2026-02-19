package main.java;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum_CountEqualNoOf1sAnd0s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,1,0,1,0,1,1,0,1,0,1};
		int sum=0;
		Map<Integer, Integer> map=new HashMap<>();
		map.put(0, 1);
		int total=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				sum-=1;
			}  else {
				sum+=1;
			}
			if(map.containsKey(sum)) {
				//total+=map.get(sum); //use below or this
			}
			total+=map.getOrDefault(sum, 0);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		System.out.println(total);
	}

}
