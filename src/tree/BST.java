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
    Node insert(Node root, int x){
        if(root == null) return new Node(x);
        if(root.data > x){
            root.left = insert(root.left, x);
        }
        if(root.data < x){
            root.right = insert(root.right, x);
        }
        return root;
    }
    Node insertIterative(Node root, int x){
        Node node = new Node(x);
        Node curr = root;
        Node parent = null;
        while(curr != null){
            parent = curr;
            if(curr.data > x){
                curr = curr.left;
            } else curr = curr.right;
        }
        if(parent != null){
            if(parent.data > x){
                parent.left = node;
            }else if(parent.data < x){
                parent.right = node;
            }
            return root;
        }
        return node;
    }
    public static void main(String[] args){
        BST obj = new BST();
        Node root = obj.createTree();
        System.out.print("Enter target element: ");
        int target = obj.sc.nextInt();
        boolean ans = obj.searchElement(root, target);
//        80 60 40 -1 50 -1 -1 70 -1 72 -1 -1 160 -1 -1
        root = obj.insert(root, target);
        root = obj.insertIterative(root, target);
        obj.display(root);
    }
}
