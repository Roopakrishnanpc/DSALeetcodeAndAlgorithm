package main.java;

public class PalindromNumber {
	public static void main(String[] args) {
		int num = 121;      // original number
		int original = num; // save original
		int reversed = 0;

		while (num > 0) {
		    int digit = num % 10;         // get last digit
		    reversed = reversed * 10 + digit; // build reversed number
		    num = num / 10;               // remove last digit
		}

		if (reversed == original) {
		    System.out.println("Palindrome");
		} else {
		    System.out.println("Not Palindrome");
		}

	}
}
