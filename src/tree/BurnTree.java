package tree;

import java.util.Scanner;

public class BurnTree extends featuredBT{
    class Depth{
        int d;
        public Depth(int d){
            this.d = d;
        }
    }
    static int ans = -1;

    int burn(Node root, int target, Depth depth){
        if(root == null) return 0;
        if (root.data == target) {
            depth.d = 1;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld);
        int rh = burn(root.right, target, rd);

        if(ld.d != -1){
            ans = Math.max(ans, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != -1){
            ans = Math.max(ans, rd.d + 1 + lh);
            depth.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }
    int minimumTime(Node root, int target) {
        Depth depth = new Depth(-1);
        return burn(root, target, depth);
    }
    public static void main(String[] args){
        BurnTree obj = new BurnTree();
        Node root = obj.createTree();
        System.out.print("Enter target node: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int result = obj.minimumTime(root, target);
        System.out.println("Total time required to burn tree: " + result);
        // Wrong output it will always give 5
//        1 2 4 -1 -1 5 7 -1 -1 8 -1 -1 3 6 9 10 -1 -1 -1 -1 -1
    }
}
