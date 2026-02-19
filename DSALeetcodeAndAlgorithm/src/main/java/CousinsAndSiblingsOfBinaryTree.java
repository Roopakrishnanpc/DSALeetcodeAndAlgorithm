package main.java;
import java.util.*;

class BinaryNode {
    int data;
    BinaryNode left, right;
    BinaryNode(int d) { data = d; }
}

public class CousinsAndSiblingsOfBinaryTree {

    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(20);
        root.left = new BinaryNode(8);
        root.right = new BinaryNode(7);
        root.left.left = new BinaryNode(12);
        root.left.right = new BinaryNode(15);
        root.right.right = new BinaryNode(19);

        BinaryNode BinaryNode1 = root.left.left;  // 12
        BinaryNode BinaryNode2 = root.left.right; // 15

        checkCousinsOrSiblings(root, BinaryNode1, BinaryNode2);
    }

    static void checkCousinsOrSiblings(BinaryNode root, BinaryNode BinaryNode1, BinaryNode BinaryNode2) {
        Map<BinaryNode, BinaryNode> parentMap = new HashMap<>();
        Map<BinaryNode, Integer> levelMap = new HashMap<>();

        // BFS queue
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(root);
        //default
        parentMap.put(root, null); 
        levelMap.put(root, 0);     

        while (!queue.isEmpty()) {
            BinaryNode curr = queue.poll();
            int currLevel = levelMap.get(curr);

            if (curr.left != null) {
                queue.offer(curr.left);
                parentMap.put(curr.left, curr);//adding left, its root
                levelMap.put(curr.left, currLevel + 1);//adding left, its level
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                parentMap.put(curr.right, curr);
                levelMap.put(curr.right, currLevel + 1);
            }
        }

        BinaryNode parent1 = parentMap.get(BinaryNode1);
        BinaryNode parent2 = parentMap.get(BinaryNode2);
        int level1 = levelMap.get(BinaryNode1);
        int level2 = levelMap.get(BinaryNode2);

        if (parent1 == parent2) {
            System.out.println(BinaryNode1.data + " and " + BinaryNode2.data + " are Siblings");
        } else if (level1 == level2) {
            System.out.println(BinaryNode1.data + " and " + BinaryNode2.data + " are Cousins");
        } else {
            System.out.println(BinaryNode1.data + " and " + BinaryNode2.data + " are Neither cousins nor siblings");
        }
    }
}

/*
 * 
 * import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

// Helper class to track node, parent, and level
class NodeInfo {
    Node node;
    Node parent;
    int level;

    NodeInfo(Node node, Node parent, int level) {
        this.node = node;
        this.parent = parent;
        this.level = level;
    }
}

public class CousinsAndSiblings {

    public static void main(String[] args) {
        // Build the tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(7);
        root.left.left = new Node(12);
        root.left.right = new Node(15);
        root.right.right = new Node(19);

        // Test nodes
        Node node1 = root.left.left;  // 12
        Node node2 = root.left.right; // 15
        Node node3 = root.right.right; // 19

        checkCousinsOrSiblings(root, node1, node2); // siblings
        checkCousinsOrSiblings(root, node1, node3); // cousins
        checkCousinsOrSiblings(root, node2, node3); // cousins
    }

    static void checkCousinsOrSiblings(Node root, Node node1, Node node2) {
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, null, 0));

        NodeInfo info1 = null, info2 = null;

        // BFS traversal
        while (!queue.isEmpty() && (info1 == null || info2 == null)) {
            NodeInfo currInfo = queue.poll();
            Node currNode = currInfo.node;

            if (currNode == node1) info1 = currInfo;
            if (currNode == node2) info2 = currInfo;

            if (currNode.left != null)
                queue.offer(new NodeInfo(currNode.left, currNode, currInfo.level + 1));
            if (currNode.right != null)
                queue.offer(new NodeInfo(currNode.right, currNode, currInfo.level + 1));
        }

        if (info1 == null || info2 == null) {
            System.out.println("One or both nodes not found in the tree.");
            return;
        }

        if (info1.parent == info2.parent) {
            System.out.println(node1.data + " and " + node2.data + " are Siblings");
        } else if (info1.level == info2.level) {
            System.out.println(node1.data + " and " + node2.data + " are Cousins");
        } else {
            System.out.println(node1.data + " and " + node2.data + " are Neither cousins nor siblings");
        }
    }
}
*/
