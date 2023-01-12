package tree;

public class Practice extends featuredBT {
    int diameter(Node root){
        if(root == null) return 0;
        int ld = diameter(root.left);
        int rd = diameter(root.right);

        int ans = 1 + height(root.left) + height(root.right);
        return Math.max(ans, Math.max(ld, rd));
    }
    public static void main(String[] args){
        Practice obj = new Practice();
        Node root = obj.createTree();
        int ans = obj.diameter(root);
        System.out.println("diameter of tree: " + ans);
    }
}
