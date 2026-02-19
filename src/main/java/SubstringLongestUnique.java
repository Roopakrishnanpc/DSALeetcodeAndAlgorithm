package main.java;

import java.util.HashSet;
import java.util.Set;

public class SubstringLongestUnique {
	public static void main(String[] args) {
		String s = "abcabcdd";
		Set<Character> set=new HashSet<>();
		int start=0, maxSubstring=0;//i is end
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			while(set.contains(ch))
			{
				set.remove(s.charAt(start));
				start++;
			}
			set.add(ch);
			if(i-start+1>maxSubstring)
			{
				maxSubstring=Math.max(maxSubstring, i-start+1);
				sb=new StringBuilder();//sb.setLength(0);
				sb.append(s.substring(start, i+1));
			}
		}
		System.out.println(maxSubstring);
		System.out.println(sb.toString());
	}
}
