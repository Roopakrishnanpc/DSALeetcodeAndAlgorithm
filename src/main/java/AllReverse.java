package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllReverse {
	public static void main(String[] args) {
		System.out.println(reverseAWord("hello"));
		System.out.println(reverseASentence("hi how are you?"));
		System.out.println(reverseASentenceByWord("hi how are you?"));
		String[] str={"hi", "hello", "how", "are", "you"};
		char[] ch= {'c','h','l','w','r','o'};
		String[] s=reverseArrayOfWords(str);
		for(String st:s) {
			System.out.println(st);
		}
		//System.out.println(reverseArrayOfChar(ch));
		char[] cha=reverseArrayOfChar(ch);
		for(char st:cha) {
			System.out.println(st);
		}
		System.out.println(reverseUsingStream("hello how are you"));
		System.out.println(reverseAWordUsingStream("hello how are you"));

		System.out.println(reverseASentenceUsingStream("hi how are you?"));
		//System.out.println(reverseASentenceByWordUsingStream("hi how are you?"));
		String[] s3=reverseASentenceByWordUsingStream("hi how are you?");
		for(String st:s3) {
			System.out.print(st);
		}
		System.out.println();
		//System.out.println(reverseArrayOfWordsUsingStream(str));
		String[] s2=reverseArrayOfWordsUsingStream(str);
        for (String st : s2) {
            System.out.print(st + " ");
        }
		System.out.println();
	    char[] reversed = reverseArrayOfCharUsingStream(ch);

	    for (char c : reversed) {
	        System.out.print((char) ('0' + c));
	    }
	   

		System.out.println();
	}

	private static char[] reverseArrayOfCharUsingStream(char[] ch) {
		// TODO Auto-generated method stub
		return new String(IntStream.rangeClosed(0,ch.length-1).map(e ->ch[ch.length-e-1])                    
				.collect(StringBuilder::new,                // collect to StringBuilder
                StringBuilder::append, 
                StringBuilder::append)
       .toString()
       ).toCharArray();   
	}

	private static char[] reverseArrayOfChar(char[] chars) {
		// TODO Auto-generated method stub
	    int left = 0;
	    int right = chars.length - 1;
		while(left<right) {
			char temp=chars[left];
			chars[left]=chars[right];
			chars[right]=temp;
			left++;
			right--;
			
		}
		return chars;
	}

	private static String[] reverseArrayOfWordsUsingStream(String[] str) {
		// TODO Auto-generated method stub
	    return IntStream.range(0, str.length)
                .mapToObj(i -> str[str.length - 1 - i]) 
                .toArray(String[]::new); 
	    
	    //return Arrays.stream(str).map(e -> new StringBuilder(e).reverse().toString()).toArray(String[]::new);
	}

	private static String[] reverseASentenceByWordUsingStream(String string) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		return Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
	}

	private static String reverseASentenceUsingStream(String string) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		return Arrays.stream(s).reduce((a,b)-> b +" "+ a ).orElse(" "); 
	}
	private static String reverseAWordUsingStream(String string) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		return Arrays.stream(s).map(e -> new StringBuilder(e).reverse().toString()).collect(Collectors.joining(" "));
	}

	private static String reverseUsingStream(String string) {
		// TODO Auto-generated method stub
		return IntStream.range(0, string.length()).mapToObj(e ->(char)string.charAt(string.length()-1-e)).collect(StringBuilder::new,
				StringBuilder::append, StringBuilder::append).toString();
	}

	private static String[] reverseArrayOfWords(String[] str) {
		// TODO Auto-generated method stub
		//approach 1:
		int i=0;
		for(String string:str) {
			char[] chars = string.toCharArray();
		    int left = 0;
		    int right = chars.length - 1;
			while(left<right) {
				char temp=chars[left];
				chars[left]=chars[right];
				chars[right]=temp;
				left++;
				right--;	
			}
			str[i++]=new String(chars);
		}
		return str;
	}

	private static String reverseASentenceByWord(String string) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=s.length-1; i>=0; i--) {
			sb.append(s[i]);
			if(i!=0) {
				sb.append(" ");
			}
		}
		//aproach2
		int left=0;
		int right=s.length-1;
		while(left<right) {
			String temp=s[left];
			s[left]=s[right];
			s[right]=temp;
			left++;
			right--;
		}
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.toString();
		char[] c=string.toCharArray();
		int l=0;
		int r=c.length-1;
		while(l<r) {
			char temp=c[l];
			c[l]=c[r];
			c[r]=temp;
			l++;
			r--;
		}
		System.out.println("another way");
		for(char ch:c) {
			System.out.print(ch);
		}
		System.out.println();
		return String.join(" ",s);
	}

	private static String reverseASentence(String string) {
		// TODO Auto-generated method stub
		String[] s=string.split(" ");
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<s.length; i++) {
			//for(String str:s) {
			char[] chars = s[i].toCharArray();
			//string.toCharArray();
		    int left = 0;
		    int right = chars.length - 1;
			while(left<right) {
				char temp=chars[left];
				chars[left]=chars[right];
				chars[right]=temp;
				left++;
				right--;
				
			}
	        sb.append(new String(chars));
	        if (i < s.length - 1) {
	            sb.append(" ");
	        }
		}
	
		return sb.toString();
	}

	private static String reverseAWord(String string) {
		// TODO Auto-generated method stub
		//string=hello;
		//aproach 1;
		char[] chars = string.toCharArray();
	    int left = 0;
	    int right = chars.length - 1;
		while(left<right) {
			char temp=chars[left];
			chars[left]=chars[right];
			chars[right]=temp;
			left++;
			right--;
			
		}
		//return new String(chars);
		StringBuilder sb=new StringBuilder(string);
		for(char c:string.toCharArray()) {
			sb.append(c);
		}
		new StringBuilder(string).reverse().toString();
		sb.reverse().toString();
		//apprach 3(recursion): 
		if(string==null || string.length() <=1)
			return string;
		//reverseAword(string.substring(1)+string.charAt(0));
		return sb.toString();
	}

}
