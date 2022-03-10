package maths;

public class FindUnique {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 3, 4, 2, 5};

        System.out.println(ans(arr));
    }
    static int ans(int[] arr){
        int unique = 0;
        for (int ele : arr) {
            unique =unique ^ele;
        }
        return unique;
    }
}
