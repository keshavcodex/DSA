package BinaryTree;

import java.util.Scanner;

public class BST {
    int idx = -1;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node buildTree() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == -1) return null;
        Node node = new Node(input);
        System.out.print("Enter left node of " + node.data + ": ");
        node.left = buildTree();
        System.out.print("Enter right node of " + node.data + ": ");
        node.right = buildTree();
        return node;
    }

    Node buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    Node buildBinarySearch() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter node value: ");
        int input = sc.nextInt();
        if (input == -1) return null;
        return buildBinarySearch(new Node(input));
    }

    Node buildBinarySearch(Node root) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter node value: ");
        int input = sc.nextInt();
        if (input == -1) return root;
        if (root == null) return new Node(input);
        else if (input < root.data) root.left = insert(root.left, input);
        else if (input > root.data) root.right = insert(root.right, input);
        return buildBinarySearch(root);
    }

    Node insert(Node root, int val) {
        if (val == -1) return root;
        if (root == null) return new Node(val);
        else if (val < root.data) root.left = insert(root.left, val);
        else if (val > root.data) root.right = insert(root.right, val);
        return root;
    }

    boolean search(Node root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        return search(root.left, target) || search(root.right, target);
    }

    Node serachNode(Node root, int target) {
        if (root == null || root.data == target) return root;
        Node leftAns = serachNode(root.left, target);
        if (leftAns != null) return leftAns;
        return serachNode(root.right, target);
    }

    static void display(Node root) {
        if (root == null) return;
        if (root.left != null) display(root.left);
        System.out.print(root.data + " ");
        if (root.right != null) display(root.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();
//        int[] nodeData = {40, 20, 10, -1, -1, 30, -1, -1, 50, -1, 60, -1, -1};
////        System.out.print("Enter root node data: ");
//        Node root = tree.buildTree(nodeData);
//        int target = 34;
////        System.out.println(tree.search(root, target) ? "Target found" : "Target not found");
//        tree.display(root);
//        tree.insert(root, target);
//        System.out.println();
//        tree.display(root);
//        System.out.println("\nSearching node...");
//        Node ans = tree.serachNode(root, 20);
//        tree.display(ans);
        Node root = tree.buildBinarySearch();
        tree.display(root);
    }
}
