package main.java;

import java.util.HashMap;
import java.util.Map;

public class MiniumCharactersInASubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="ACGHBASKKCBBANWC";
		String s2="ABC";
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0; i<s2.length(); i++) {
			map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0)+1);
		}
		int matchCount=0, minLength=Integer.MAX_VALUE, right=0, left=0, subStart=0;
		for(right=0; right<s1.length(); right++) {
			char ch=s1.charAt(right);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)-1);
				if(map.get(ch)>=0) {
					matchCount++;
				}
				while(matchCount==s2.length()) {
					if(minLength>right-left+1) {
						minLength=right-left+1;
						subStart=left;
					}
					//for max length u dont this logic
					if(map.containsKey(s1.charAt(left))) {
						if(map.get(s1.charAt(left))==0) {
							matchCount--;
						}
						map.put(s1.charAt(left), map.get(s1.charAt(left))+1);
					}
					left++;
				}
			}
		}
		System.out.println(s1.substring(subStart, subStart+minLength));
	}

}
