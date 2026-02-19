package main.java;

import java.util.Arrays;

public class ReverseSpecificWordsJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="Roopa is a good girl";
		Arrays.stream(s.split(" ")).map(e-> e.length()==4? new StringBuilder(e).reverse():e).forEach(System.out::println);;
	}

}
