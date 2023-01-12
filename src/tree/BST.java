package tree;

public class BST extends BT{
    boolean searchElement(Node root, int target){
        if(root == null) return false;
        boolean ans = false;
        if(root.data > target){
            ans = searchElement(root.left, target);
        }
        if(root.data < target){
            ans = searchElement(root.right, target);
        }
        if(root.data == target) ans = true;
        return ans;
    }
    public static void main(String[] args){
        BST obj = new BST();
        Node root = obj.createTree();
        System.out.print("Enter target element: ");
        int target = obj.sc.nextInt();
        boolean ans = obj.searchElement(root, target);
        System.out.println(ans);
//        20 10 5 -1 -1 15 -1 -1 30 25 -1 -1 40 -1 -1
    }
}
