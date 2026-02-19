package main.java;

public class MergeTwoLLinkedist {
	public static void main(String[] args) {
		ReverseNode l1=new ReverseNode(1);
		l1.next=new ReverseNode(2);
		l1.next.next=new ReverseNode(9);
		ReverseNode l2=new ReverseNode(1);
		l2.next=new ReverseNode(2); 
		l2.next.next=new ReverseNode(9);
		ReverseNode curr =mergeTwoLists(l1,l2);
		printReverseNode(curr);
		
	}

	private static ReverseNode mergeTwoLists(ReverseNode l1, ReverseNode l2) {
		// TODO Auto-generated method stub
		ReverseNode dummy=new ReverseNode(0);
		ReverseNode curr=dummy;
		while(l1!=null && l2!=null) {
			if(l1.data>l2.data) {
				curr.next=new ReverseNode(l2.data);
				l2=l2.next;
			} else {
				curr.next=new ReverseNode(l1.data);
				l1=l1.next;
			}
			curr = curr.next;
		}
		while(l1!=null) {
			curr.next=new ReverseNode(l1.data);
			l1=l1.next;
			curr = curr.next;
		}
		while(l2!=null) {
			curr.next=new ReverseNode(l2.data);
			l2=l2.next;
			curr = curr.next;
		}
		return dummy.next;
	}
	private static void printReverseNode(ReverseNode prev) {
		// TODO Auto-generated method stub
		while(prev!=null) {
			System.out.println(prev.data + " ");
			prev=prev.next;
		}
	}
}
