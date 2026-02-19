package main.java;

public class FindDuplicateBoyerMoore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,3,4,5,5,5,5,2,2,2};
		int count=0, candidate=0;
		for(int val:arr) {
			if(count==0) {
				candidate=val;
			}
			count+=candidate==val?+1:-1;
		}
		System.out.println(candidate);
		count=0;
		for(int i=0; i<arr.length;i++) {
			if(candidate==arr[i]) count+=1;
		}
		if(count> arr.length/2) {
			System.out.println(candidate);
		}
	}

}
