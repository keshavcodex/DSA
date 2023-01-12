package tree;
public class DiameterOFBT extends featuredBT{
    int ans = 0;
    int diameter(Node root){
        if(root == null) return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int current = height(root.left) + height(root.right) + 1;
        return Math.max(current, Math.max(leftDiameter, rightDiameter));
    }
    int height(Node root) {
        if(root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        ans = Math.max(ans, (1 + lheight + rheight));
        return 1 + Math.max(lheight, rheight);
    }
    public static void main(String[] args){
        DiameterOFBT obj = new DiameterOFBT();
        Node root = obj.createTree();
        int diameter = obj.diameter(root);
        System.out.println("diameter is: " + diameter);
    }
//    5 2 3 -1 -1 4 -1 -1 6 1 -1 -1 7 -1 -1
//    6 7 1 4 3 -1 -1 -1 2 -1 -1 -1 5 -1 -1
}
