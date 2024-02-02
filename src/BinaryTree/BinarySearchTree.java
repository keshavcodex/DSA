package BinaryTree;

public class BinarySearchTree {
    public class Node {
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getValue() {
            return val;
        }
    }

    private Node root;

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) return;
        System.out.println(node.getValue());
        display(node.left);
        display(node.right);
    }

    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        } else if (val < node.val) {
            node.left = insert(val, node.left);
        } else if (val > node.val) {
            node.right = insert(val, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private boolean balanced(Node node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left) && balanced(node.right);
    }
}
