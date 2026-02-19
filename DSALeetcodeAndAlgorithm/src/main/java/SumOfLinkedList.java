package main.java;

public class SumOfLinkedList {
	public static void main(String[] args) {
		ReverseNode l1=new ReverseNode(1);
		l1.next=new ReverseNode(2);
		l1.next.next=new ReverseNode(9);
		ReverseNode l2=new ReverseNode(1);
		l2.next=new ReverseNode(2); 
		l2.next.next=new ReverseNode(9);
		ReverseNode curr=addTwoLists(l1,l2);
		curr=reverseALinkedList(curr);
		ReverseNode l3=new ReverseNode(9);
		l3.next=new ReverseNode(9); 
		l3.next.next=new ReverseNode(9);
		ReverseNode sumOne=sumOne(l3);
		printReverseNode(sumOne);
	}


	private static ReverseNode sumOne(ReverseNode curr) {
		// TODO Auto-generated method stub
		curr=reverseALinkedList(curr);
		int carry=1;
		ReverseNode head=curr;
		while(head!=null && carry>0 ) {
			if(head.data ==9) {
				head.data=0;
				carry=1;
			} else {
				head.data+=carry;
				carry=0;
			}
			head=head.next;
		}
		if(carry>0) {
			ReverseNode remainingOneIfPresent=new ReverseNode(1);
			remainingOneIfPresent.next=curr;
			curr=remainingOneIfPresent;
			return curr;
		}
		return reverseALinkedList(curr); 
	}


	private static ReverseNode addTwoLists(ReverseNode l1, ReverseNode l2) {
		// TODO Auto-generated method stub
		l1=reverseALinkedList(l1);
		l2=reverseALinkedList(l2);
		ReverseNode dummy=new ReverseNode(0);
		ReverseNode curr=dummy;
		int carry=0;
		while(l1!=null || l2!=null || carry!=0) {
			int sum=carry;
			if(l1!=null) {
				sum+=l1.data;
				l1=l1.next;
			}
			if(l2!=null) {
				sum+=l2.data;
				l2=l2.next;
			}
			carry=sum/10;
			curr.next=new ReverseNode(sum%10);
			curr=curr.next;
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


	private static ReverseNode reverseALinkedList(ReverseNode ReverseNode) {
		// TODO Auto-generated method stub
		ReverseNode curr=ReverseNode;
		ReverseNode prev=null;
		while(curr !=null) {
			ReverseNode temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}
}
