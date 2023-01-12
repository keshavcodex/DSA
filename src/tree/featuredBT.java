package tree;

public class featuredBT extends BT{
    int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        featuredBT obj = new featuredBT();
        Node root = obj.createTree();
        int height = obj.height(root);
        System.out.println(height);
    }
}
