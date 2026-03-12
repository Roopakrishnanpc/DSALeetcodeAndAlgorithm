package main.java;

import java.util.HashMap;
import java.util.Map;

public class Twosum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target. 
		int[] arr = {0, -1, 2, -3, -1}; //b.compareto(a)
		int target = -2;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0; i<arr.length; i++) {//0-1
			int compliment=target-arr[i];
			if(map.containsKey(compliment)) {
				System.out.println(compliment + " "+ arr[i]);
			}
			map.put(arr[i],i );
		}
	}

}
