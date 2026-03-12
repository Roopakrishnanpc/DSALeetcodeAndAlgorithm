package main.java;

import java.util.Arrays;
import java.util.List;

public class DuplicateRemovalListSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list= {9,3,5,6,2,1,0,9,7,5,8,4,4,-1};
		
		for(int i=0; i<list.length; i++) {
			for(int j=i; j<list.length; j++) {
				if(list[j]<list[i]) {//5<3
					int temp=list[i];
					list[i]=list[j];
					list[j]=temp;
				}
			}
		}
		int[] result=new int[list.length];
		int j=0;
		for(int i=0; i<list.length-1; i++) {
			
			if(list[i]==list[i+1]) {
				result[j]=list[i];//result[i+1]=0
				i++;
				j++;
				continue;
			}
			result[j]=list[i];
			j++;
		}
		
		for(int i=0; i<j; i++) {
			System.out.println(result[i]);
		}
		
	}

}
