package main.java;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="egg";
		String t="lej";
		Map<Character, Character> mapS=new HashMap<>();
		Map<Character, Character> mapT=new HashMap<>();
		if(s.length()>t.length()) {
			System.out.println(false);
			return;
		}
		for(int i=0; i<s.length(); i++) {
			char charS=s.charAt(i);
			char charT=t.charAt(i);
			if(mapS.containsKey(charS) && mapS.get(charS)!=charT) {
				System.out.println(false);
				return;
			}
			if(mapT.containsKey(charT) && mapT.get(charT)!=charS) {
				System.out.println(false);
				return;
			}
			mapS.put(charS, charT);
			mapT.put(charT, charS);
		}
		System.out.println("true");
		
	}

}
