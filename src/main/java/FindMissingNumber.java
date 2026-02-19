package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr= {3,4,5,1};
		int xor=0;
		for(int i=0; i<arr.length; i++) {
			xor^=arr[i];//0^3^4^5^1^1^2^3^4^0
		}
		for(int i=0; i<=arr.length+1; i++) {
			xor^=i;
		}
		System.out.println(xor);
		
		Set<Integer> set=new HashSet<>();
		for(int s:arr) {
			set.add(s);
		}
		for(int i=1; i<=arr.length+1; i++) {
			if(!set.contains(i))
			{
				System.out.println(i);
			}
		}
		int N=arr.length;
		int miss = (N+1)*(N+2) / 2;
		int sum=Arrays.stream(arr).sum();
		System.out.println(miss-sum);
	}

}
