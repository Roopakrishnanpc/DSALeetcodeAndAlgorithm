package main.java;

import java.util.Arrays;

public class CountAnagarm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="sililent";
		String s2="il";
		int[] s1Count=new int[26];
		int[] s2Count=new int[26];
		for(int i=0; i<s2.length(); i++) {
			s1Count[s1.charAt(i)-'a']++;
			s2Count[s2.charAt(i)-'a']++;
		}
		int count=0;
		for(int i=0;i<=s1.length()-s2.length(); i++) {
			if(Arrays.equals(s1Count, s2Count))count++;
			if(i+s2.length()<s1.length()) {
				s1Count[s1.charAt(i)-'a']--;
				s1Count[s1.charAt(i+s2.length())-'a']++;
			}
		}
		System.out.println(count);
	}

}
