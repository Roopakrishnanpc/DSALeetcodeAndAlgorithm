package main.java;

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1= {1,3,4,8};
		int[] l2= {2,3,5};
		int left=0, right=0, i=0;
		int[] result=new int[l1.length+l2.length];
		while(l1.length>left && l2.length>right) {
			if(l1[left]<l2[right]) {//1<2
				result[i++]=l1[left];
				left=left+1;
			} else {
				result[i++]=l2[right];
				right=right+1;
			}
		}
		while(l1.length>left) {
			result[i++]=l1[left];
			left=left+1;
		}
		while(l2.length>right) {
			result[i++]=l2[right];
			right=right+1;
		}
		for(int num:result)
			System.out.println(num);
	}

}
