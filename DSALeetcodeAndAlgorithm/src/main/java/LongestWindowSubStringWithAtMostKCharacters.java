package main.java;

import java.util.HashMap;
import java.util.Map;

public class LongestWindowSubStringWithAtMostKCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="araaaaaci";//every charcater must be at most 2 times 
		int k=2;
		int start=0, maxLength=0;
		int maxStart=0;
		Map<Character, Integer> map=new HashMap<>();
		for(int end=0; end<s.length(); end++) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
			while(map.get(s.charAt(end))>k) {
				map.put(s.charAt(start), map.get(s.charAt(start))-1);
				start++;
			}
			
		    if (end - start + 1 > maxLength) {
		        maxLength = end - start + 1;//maxLength=Math.max(maxLength, end-start+1);
		        maxStart = start;
		    }
		}
		System.out.println(maxLength);
		System.out.println(s.substring(maxStart,maxStart+maxLength));
	}

}
