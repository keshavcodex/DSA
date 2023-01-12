package tree;
import java.util.Scanner;

public class BT {
    Scanner sc =  new Scanner(System.in);
    BT(){
        System.out.println("Enter root node: ");
    }
    public Node createTree() {
        int data = sc.nextInt();
        if (data == -1) return null;
        Node root = new Node(data);
        System.out.println("Enter left node of " + data);
        root.left = createTree();
        System.out.println("Enter right node of " + data);
        root.right = createTree();
        return root;
    }
    void display(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        BT obj = new BT();
        Node root = obj.createTree();
        obj.display(root);
//        2 4 7 6 -1 -1 -1 10 -1 -1 1 4 -1 -1 -1
//        2, 4, 7, 6, -1, -1, -1, 10, -1, -1, 1, 4, -1, -1, -1

    }
}

class Node{
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
    }
}

