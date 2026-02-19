package main.java;

import java.util.PriorityQueue;

public class KthLargestAndSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {95, 7,8,2,11,22,88};
		int k=3;
		int kthSmallest=kthSmallest(arr,k);
		System.out.println(kthSmallest);
		int kthLargest=kthLargest(arr,k);
		System.out.println(kthLargest);
	}

	private static int kthLargest(int[] arr,int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		for(int num:arr) {
			priorityQueue.offer(num);
			if(priorityQueue.size()>k) {
				priorityQueue.poll();
			}
		}
		return priorityQueue.peek();
	}

	private static int kthSmallest(int[] arr, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
		for(int num:arr) {
			priorityQueue.offer(num);
		}
		int kthSmallest=-1;
		for( int i=0; i<k; i++) {
			kthSmallest=priorityQueue.poll();
		}
		return kthSmallest;
	}
	

}
