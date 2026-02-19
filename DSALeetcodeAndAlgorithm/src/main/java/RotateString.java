package main.java;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdefg";
		String s1="cdefgab";
		if(s.length()>s1.length()) {
			System.out.println(false);
			return;
		}
		System.out.println((s+s1).contains(s));
	}

}
