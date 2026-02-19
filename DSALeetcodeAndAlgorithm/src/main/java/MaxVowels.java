package main.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ahekoiu";
		int k=3;
		int start=0;
		Set<Character> vowel=new HashSet<>(Arrays.asList('a','e','i','o','u'));
		int vowelCount=0, maxVowel=0,end=0;
		for(char ch:s.toCharArray()) {
			if(vowel.contains(ch)) {
				vowelCount++;
			}
			//end=3 and k =3
			if(end>=k && vowel.contains(s.charAt(end-k))) {
				vowelCount--;
			}
			//end=2 and k-1=2
			//end 3 and k-1=2
			//end 4 and k-12
			if(end>=k-1) {
				maxVowel=Math.max(maxVowel, vowelCount);
			}
			end++;
		}
		System.out.println(maxVowel);

			vowelCount=0;maxVowel=0;
			//similar to 
			for (end = 0; end < s.length(); end++) {

			    // add right character
			    if (vowel.contains(s.charAt(end))) {
			        vowelCount++;
			    }

			    // shrink window if size exceeds k
			    if (end - start + 1 > k) {
			        if (vowel.contains(s.charAt(start))) {
			            vowelCount--;
			        }
			        start++;
			    }

			    // window size exactly k
//			    k - 1 comes from 0-based index.
//
//			    When end == k - 1 and start = 0 → window size = end - start + 1 = k. ✅
//
//			    For every subsequent end, the window slides forward, so you keep updating maxVowel.
//
//			    This is correct, because we want the max in any window of size k, not just the first one.
			    if (end - start + 1 == k) {
			        maxVowel = Math.max(maxVowel, vowelCount);
			    }
			}
		
		System.out.println(maxVowel);
	}

}
