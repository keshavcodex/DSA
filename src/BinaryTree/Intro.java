package BinaryTree;

import java.util.Scanner;

public class Intro {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    //insert elements
    public void populate(Scanner sc) {
        System.out.print("Enter the root node value: ");
        root = new Node(sc.nextInt());
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {

        System.out.print("Enter the left node of " + node.val + ": ");
        int leftInput = sc.nextInt();
        if (leftInput != -1) {
            node.left = new Node(leftInput);
            populate(sc, node.left);
        }
        System.out.print("Enter the right node of " + node.val + ": ");

        int rightInput = sc.nextInt();
        if (rightInput != -1) {
            node.right = new Node(rightInput);
            populate(sc, node.right);
        }
    }

    public void display() {
        displayDFS(root);
    }

    private void displayDFS(Node node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        displayDFS(node.left);
        displayDFS(node.right);
    }

    public static void main(String[] args) {
        Intro obj = new Intro();
        Scanner sc = new Scanner(System.in);
        obj.populate(sc);
        obj.display();
    }

}
