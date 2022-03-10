package oops.cloning;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3, 4, 5, 6, 9, 1};
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        //This whole operation is deep copy
        Human twin = (Human) super.clone(); //This is actually shallow copy
        // making of a deep copy
        twin.arr = new int[twin.arr.length];
        System.arraycopy(this.arr, 0, twin.arr, 0, twin.arr.length);
        return twin;
    }
}
