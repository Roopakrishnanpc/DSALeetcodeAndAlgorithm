package main.java;

import java.util.Arrays;

public class KokoEatingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles= {3,4,2,1,4,7};
		int h=1;
		int left=1;
		int right=Arrays.stream(piles).max().getAsInt();
		while(left<right) {
			int mid=left-(right-left)/2;
			int hours=0;
			for(int num:piles) {
				hours+=(num+mid-1)/mid;
			}
			if(hours<=h) right=mid;
			else left=mid+1;
		}
		System.out.println(left);
	}

}
