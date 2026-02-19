package main.java;

import java.util.Arrays;

public class LongestPrefixCommon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr= {"flower", "flow","flight"};
		String prefix=arr[0];
		for(int i=1; i<arr.length; i++) {
			while(!arr[i].startsWith(prefix)) {//!false=true
				prefix=prefix.substring(0, prefix.length()-1);
			}
		}
		System.out.println(prefix);
		String pre=arr[0];
		Arrays.stream(arr).map(String::toString).filter(e-> e.startsWith(pre)).map(l->pre.substring(0, arr.length-1)).forEach(System.out::println);
	}

}
