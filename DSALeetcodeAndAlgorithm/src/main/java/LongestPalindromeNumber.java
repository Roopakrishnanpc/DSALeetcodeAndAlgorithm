package main.java;

public class LongestPalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num="378587";
		//left + optional middle + reverse left
		int[] count=new int[10];
		for(char c:num.toCharArray()) {
			count[c-'0']++;
		}
		StringBuilder sb=new StringBuilder();
		for(int d=9; d>=0; d--) {
			int pairs=count[d]/2;
			if(d==0 && sb.length()==0) continue;
			for(int i=0; i<pairs; i++) {
				sb.append(d);
			}
			count[d]-=pairs*2;//count[9]=count[9]-(0*2)=1, count[8]=count[8]-(1*2)
		}
		
		String middle="";
		for(int d=9; d>=0; d--) {
			if(count[d]>0) {
				middle=String.valueOf(d);
				break;
			}
		}
		String right=sb.reverse().toString();
		sb.reverse();
		String result=sb.toString()+middle+right;
		if(result.length()==0) System.out.println(0);
		System.out.println(result);
	}

}
