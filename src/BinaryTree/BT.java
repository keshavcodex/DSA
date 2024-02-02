package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class TreeInfo {
        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node current = q.remove();
            if (current != null) {
                System.out.print(current.data + " ");
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            } else {
                System.out.println();
                if (!q.isEmpty()) q.add(null);
            }
        }
    }

    static int nodeCount(Node root) {
        if (root == null) return 0;
        int left = nodeCount(root.left);
        int right = nodeCount(root.right);
        return left + right + 1;
    }

    static int nodeSum(Node root) {
        if (root == null) return 0;
        int left = nodeSum(root.left);
        int right = nodeSum(root.right);
        return left + right + root.data;
    }

    static int treeHeight(Node root) {
        if (root == null) return 0;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return Math.max(left, right) + 1;
    }

    static int treeDiameter(Node root) {
        if (root == null) return 0;
        int left = treeDiameter(root.left);
        int right = treeDiameter(root.right);
        int height = treeHeight(root.left) + treeHeight(root.right);
        return Math.max(height, Math.max(left, right));
    }

    static TreeInfo treeDiameter2(Node root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo left = treeDiameter2(root.left);
        TreeInfo right = treeDiameter2(root.right);
        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = right.diam;
        int mydiam = Math.max(Math.max(diam1, diam2), diam3);
        return new TreeInfo(myHeight, mydiam);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        int[] nodes = {1, 2, 3, 5, 8, -1, -1, -1, -1,  4, 6, 9, -1, -1, -1, 7, -1, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
        levelOrder(root);
        System.out.println("node count: " + nodeCount(root));
        System.out.println("node sum: " + nodeSum(root));
        System.out.println("tree height: " + treeHeight(root));
        System.out.println("tree diameter: " + treeDiameter(root));
        System.out.println("tree diameter2: " + treeDiameter2(root).diam);
    }
}
