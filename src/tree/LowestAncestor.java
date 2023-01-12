package tree;
public class LowestAncestor extends featuredBT {
    Node lowestCommonAncestor(Node root, int a, int b){
        if(root == null) return null;
        if(root.data == a || root.data == b){
            return root;
        }
        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
    public static void main(String[] args){
        LowestAncestor obj = new LowestAncestor();
        Node root = obj.createTree();
//        5 2 4 -1 1 7 -1 -1 6 -1 -1 -1 3 -1 -1
        Node ans = obj.lowestCommonAncestor(root, 4, 6);
        if (ans != null) {
            System.out.println(ans.data);
        }
    }
}
