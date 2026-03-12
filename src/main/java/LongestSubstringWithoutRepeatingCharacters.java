package main.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabcacab";
		//abc
		
		int maxLength=0;
		int left=0, right=0;
		Set<Character> set=new HashSet<>();
		for(right=0; right<s.length(); right++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			maxLength=Math.max(maxLength, right-left+1);
		}
		System.out.println(maxLength);
	}

}
