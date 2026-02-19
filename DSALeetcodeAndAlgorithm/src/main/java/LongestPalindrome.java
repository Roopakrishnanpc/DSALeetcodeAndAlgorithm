package main.java;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="racecar";
		int maxLength=0, start=0, end=0;
		for(int i=0; i<s.length(); i++) {
			int odd=expandAndCentre(s, i, i);
			int even=expandAndCentre(s, i, i+1);
			int curr=Math.max(even, odd);
			if(curr>maxLength) {
				maxLength=curr;
				int left=i-(curr-1)/2;
				int right=i+(curr)/2;
				start=left;
				end=right;
			}
		}
		System.out.println(maxLength);
		System.out.println(s.substring(start, end+1));
	}

	private static int expandAndCentre(String s, int left, int right) {
		// TODO Auto-generated method stub
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			left--;
			right++;
		}
		int curr=right-left-1;
		System.out.println(curr);
		return curr;
	}

}
