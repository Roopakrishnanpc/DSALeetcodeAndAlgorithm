package main.java;
class ReverseNode{
	int data;
	ReverseNode next;
	ReverseNode(int data){
		this.data=data;
	}
}
public class ReverseALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNode ReverseNode=new ReverseNode(1);
		ReverseNode.next=new ReverseNode(2);
		ReverseNode.next.next=new ReverseNode(7);
		/*
		 * ReverseNode ReverseNode1=new ReverseNode(1); ReverseNode1.next=new ReverseNode(2); ReverseNode1.next.next=new ReverseNode(7);
		 */
		ReverseNode prev=reverseALinkedList(ReverseNode);
		printReverseNode(prev);
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
