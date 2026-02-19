package main.java;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNode l1=new ReverseNode(1);
		l1.next=new ReverseNode(2);
		l1.next.next=new ReverseNode(9);
		l1.next.next.next=new ReverseNode(7);
		l1.next.next.next.next=new ReverseNode(9);
		l1.next.next.next.next.next=new ReverseNode(3);
		l1.next.next.next.next.next.next=new ReverseNode(1);
		System.out.println(palindromeLinkedList(l1));
	}

	private static boolean palindromeLinkedList(ReverseNode l1) {
		// TODO Auto-generated method stub
		ReverseNode fast=l1, slow=l1;
		while(fast.next!=null && fast.next.next!=null) {
			fast= fast.next.next;
			slow=slow.next;
		}
		ReverseNode prev=reverse(slow);
		ReverseNode first=l1;
		while(prev.next!=null) {
			if(first.data !=prev.data) return false;
			first=first.next;
			prev=prev.next;
		}
		return true;
	}

	private static ReverseNode reverse(ReverseNode slow) {
		// TODO Auto-generated method stub
		ReverseNode curr=slow;
		ReverseNode prev=null;
		while(curr!=null) {
			ReverseNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

}
