package main.java;

public class IncreasingTripletSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= {1,2,3,4,5};
		//GreedyPattern
		int first=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
		for(int i=0; i<num.length; i++) {
			if(num[i]<=first) {
				first=num[i];
			} else if(num[i]<=second) {
				second=num[i];
			} else {
				System.out.println(true);
				return;
			}
		}
		System.out.println(false);
	}

}
