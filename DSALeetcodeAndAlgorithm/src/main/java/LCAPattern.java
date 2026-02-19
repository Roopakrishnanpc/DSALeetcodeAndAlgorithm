package main.java;

public class LCAPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node();
		root.data = 20;
		root.left = new Node();
		root.left.data = 8;
		root.right = new Node();
		root.right.data = 7;
		root.left.left = new Node();
		root.left.left.data = 12;
		root.left.right = new Node();
		root.left.right.data = 15;
		root.right.right = new Node();
		root.right.right.data = 19;
		
		Node node=lca(root, root.left.left,root.right.right);
		System.out.println(node.data);
		print(node);
	}

	private static void print(Node node) {
		// TODO Auto-generated method stub
		if(node == null) {
			System.out.println("");
			return;
		}
		if(node.left == null && node.right==null) {
			System.out.println(node.data);
			return;
		}
		print(node.left);
		print(node.right);
	}

	private static Node lca(Node root, Node i, Node j) {
		// TODO Auto-generated method stub
		if(root == null || i==root || j==root) {
			return root;
		}
		Node left=lca(root.left, i,j);
		Node right=lca(root.right, i,j);
		if(left!=null && right !=null)
			return root;
		return left !=null ? left: right;
	}
	

}
