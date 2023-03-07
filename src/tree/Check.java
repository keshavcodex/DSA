package tree;

public class Check extends BT {
    boolean checkBST(Node root) {
        if(root == null) return true;
        if (root.left != null) {
            if(root.data < maxValue(root.left)) return false;
        }
        if (root.right != null) {
            if (root.data > minValue(root.right)) return false;
        }
        boolean leftTree = checkBST(root.left);
        boolean rightTree = checkBST(root.right);
        if(leftTree && rightTree) return true;
        return false;
    }
    int minValue(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    int maxValue(Node root){
        int max = root.data;
        while(root.right != null){
            max = root.right.data;
            root = root.right;
        }
        return max;
    }
    int min = Integer.MIN_VALUE;
    boolean checkByTraversal(Node root){
        if(root == null) return true;
        boolean leftTree = checkByTraversal(root.left);
        if(root.data < min) {
            return false;
        }
        min = root.data;
        boolean rightTree = checkByTraversal(root.right);
        return leftTree & rightTree;
    }
    public static void main(String[] args) {
        Check obj = new Check();
        Node root = obj.createTree();
        obj.display(root);
        System.out.println();
        boolean ans = obj.checkBST(root);
        System.out.println(ans);
        boolean ans2 = obj.checkByTraversal(root);
        System.out.println(ans2);
//        30 28 20 10 5 -1 -1 -1 25 22 -1 -1 27 -1 -1 -1 40 -1 -1
//        30 28 20 10 5 -1 -1 -1 25 22 -1 -1 24 -1 -1 -1 40 -1 -1
//        50 10 -1 -1 70 20 -1 -1 80 -1 -1
//        20 10 5 -1 -1 22 -1 -1 40 30 -1 -1 50 -1 -1
//        3 1 -1 2 -1 -1 5 4 -1 -1 8 7 6 -1 -1 -1 -1
//        3 1 -1 2 -1 -1 5 4 -1 -1 8 7 6 -1 -1 -1 -1
    }
}
