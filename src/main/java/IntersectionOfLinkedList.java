package main.java;

public class IntersectionOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNode l1=new ReverseNode(11);
		l1.next=new ReverseNode(12);
		l1.next.next=new ReverseNode(19);
		l1.next.next.next=new ReverseNode(10);
		ReverseNode l2=new ReverseNode(1);
		l2.next=new ReverseNode(2); 
		l2.next.next=new ReverseNode(9);
		l2.next.next.next=l1;
		ReverseNode intersect=intersectionOfLinkedList(l1,l2);
		if (intersect != null) {
		    System.out.println("Intersection at: " + intersect.data);
		} else {
		    System.out.println("No intersection");
		}
	}

	private static ReverseNode intersectionOfLinkedList(ReverseNode headA, ReverseNode headB) {
		// TODO Auto-generated method stub
		ReverseNode p1=headA;
		ReverseNode p2=headB;
		while(p1!=p2) {
			p1=(p1==null)?headB : p1.next;
			p2=(p2==null)?headA : p2.next;
		}
		return p1;
	}

}
