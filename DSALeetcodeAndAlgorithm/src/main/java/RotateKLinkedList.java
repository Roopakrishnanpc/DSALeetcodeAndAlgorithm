package main.java;

public class RotateKLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNode l1=new ReverseNode(11);
		l1.next=new ReverseNode(12);
		l1.next.next=new ReverseNode(19);
		l1.next.next.next=new ReverseNode(10);
		l1.next.next.next.next=new ReverseNode(30);
		//19 -> 10 -> 30 -> 12 -> 11
		int k=2;
		ReverseNode rotate=rotateLinkedList(l1,k);
		while(rotate!=null) {
			System.out.println(rotate.data);
			rotate=rotate.next;
		}
	}

	private static ReverseNode rotateLinkedList(ReverseNode head, int k) {
		// TODO Auto-generated method stub
		int knew=k;
		ReverseNode cutNode=head;
		while(knew>1) {
			cutNode = cutNode.next;
			knew--;
		}
		ReverseNode newNode=cutNode.next;
		cutNode.next = null;
		ReverseNode remaminingNode=newNode;
		while(remaminingNode.next!=null) {
			remaminingNode=remaminingNode.next;
		}
		remaminingNode.next=head;
		
		return newNode;
	}

}
