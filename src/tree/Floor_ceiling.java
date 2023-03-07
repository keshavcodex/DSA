package tree;

public class Floor_ceiling extends Check {
    int floor = Integer.MIN_VALUE;
    int celing = Integer.MAX_VALUE;
    void fc(Node root, int key){
        if(root == null) return;
        if(root.data < key && root.data > floor){
            floor = root.data;
        }
        if(root.data > key && root.data < celing){
            celing = root.data;
        }
        if(key > root.data){
            fc(root.right, key);
        }
        else fc(root.left, key);
//        if(root.data == key){
//            if (root.left != null) {
//                System.out.println("floor is: " + root.left.data);
//            } else {
//                System.out.println("Floor not available");
//            }
//            if (root.right != null) {
//                System.out.println("celing is: " + minValue(root.right));
//            }
//            return;

//        }
    }
    int getFloor (Node root, int key){
        if(root == null) return -1;
        int min = Integer.MIN_VALUE;
        while(root != null){
            if (root.data > min && root.data < key) {
                min = root.data;
            }
            if(root.data > key){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return min;
    }
    int getCeling (Node root, int key){
        if(root == null) return -1;
        int max = Integer.MAX_VALUE;
        while(root != null){
            if (root.data < max && root.data > key) {
                max = root.data;
            }
            if(root.data > key){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Floor_ceiling obj = new Floor_ceiling();
        Node root = obj.createTree();
        System.out.print("Enter key value: ");
        int key = obj.sc.nextInt();
        obj.display(root);
        System.out.println();
        obj.fc(root, key);
        int f = obj.getFloor(root, key);
        int c = obj.getCeling(root, key);
        System.out.println("f: " + f);
        System.out.println("c: " + c);
        System.out.println("FLoor is: " + obj.floor);
        System.out.println("Ceiling is: " + obj.celing);
//        40 20 10 -1 -1 30 -1 -1 60 -1 -1
//        8 6 -1 -1 21 15 13 -1 -1 -1 26 -1 -1
    }
}
