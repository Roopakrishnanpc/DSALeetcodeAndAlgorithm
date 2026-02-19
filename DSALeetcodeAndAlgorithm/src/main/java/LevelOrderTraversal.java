package main.java;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left, right;

}

public class LevelOrderTraversal {

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
		levelOrder(root);
		System.out.println();
		zigzagTraversal(root);
		System.out.println();
		preOrder(root);// post -> left right root, in order -> left root right
		System.out.println();
		System.out.println(leafNode(root));
		System.out.println(height(root));
		System.out.println(size(root));
		printLeafNodes(root);
	}

	private static void zigzagTraversal(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leftToRight = true;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int[] level = new int[levelSize];
			for (int i = 0; i < levelSize; i++) {
				Node curr = queue.poll();
				int idx = leftToRight ? i : levelSize - 1 - i;
				level[idx] = curr.data;
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			for (int i = 0; i < level.length; i++) {
				System.out.print(level[i] + " ");
			}
			leftToRight = !leftToRight;
		}
	}

	private static void levelOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.data + " ");
			if (curr.left != null)
				queue.offer(curr.left);
			if (curr.right != null)
				queue.offer(curr.right);
		}
	}

	private static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static int leafNode(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		return leafNode(root.left) + leafNode(root.right);
	}

	private static int height(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
//    1
//   / \
//  2   3
//     / \
//    4   5

//	height(2) = 1
//			height(4) = 1
//			height(5) = 1
//			height(3) = 1 + max(1,1) = 2
//			height(1) = 1 + max(1,2) = 3
	//LeafNode
//	leafNode(1)
//	 → leafNode(2) = 1
//	 → leafNode(3)
//	     → leafNode(4) = 1
//	     → leafNode(5) = 1
	//1 + (1 + 1) = 3
	
//	size(1)
//	 = 1 + size(2) + size(3)
//	 = 1 + 1 + (1 + 1 + 1)
//	 = 5



	private static int size(Node node) {
		if (node == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	private static void printLeafNodes(Node root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}

		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

}
