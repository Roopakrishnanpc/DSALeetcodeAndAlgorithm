package main.java;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,1};
		Set<Integer> set = new HashSet<>();
		for(int num:arr) {
			if(set.contains(num)){
				System.out.println(num);
			} set.add(num);
		}
	}

}
