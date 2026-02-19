package main.java;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="silent";
		String s2="listen";
		int[] s1Count=new int[26];
		for(int i=0; i<s1.length(); i++) {
			s1Count[s1.charAt(i)-'a']++;
			s1Count[s2.charAt(i)-'a']--;
		}
		for(int i=0; i<s1Count.length; i++) {
			if(s1Count[i]!=0) {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");

	}

}
