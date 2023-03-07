package tree;

public class DeleteNode extends BT{
    Node delete(Node root, int x){
        if(root == null) return null;
        if(root.data > x){
            root.left = delete(root.left, x);
        } else if(root.data < x){
            root.right = delete(root.right, x);
        } else {
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    static int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    public static void main(String[] args){
        DeleteNode obj = new DeleteNode();
        Node root = obj.createTree();
        System.out.print("Enter element to delete: ");
        int target = obj.sc.nextInt();
        obj.display(root);
        System.out.println();
        root = obj.delete(root, target);
        obj.display(root);
//        10 8 4 -1 -1 -1 30 -1 -1
//        30 28 20 10 5 -1 -1 -1 25 22 -1 -1 27 -1 -1 -1 40 -1 -1 20
    }
}
