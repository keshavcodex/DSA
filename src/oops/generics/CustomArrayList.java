package oops.generics;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {
    private int[] data;
    private static int default_size = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[default_size];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(data) + "\nsize=" + size;
    }

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();

        CustomArrayList list = new CustomArrayList();
//        list.add(78);
//        list.add(8);
//        list.add(865);
        for (int i = 0; i < 14; i++) {
            list.add(2*i);
        }
        System.out.println(list);
        ArrayList<String> al = new ArrayList<>();
        al.add("cool");
//        al.add(465);
        al.add("noice");
//        al.add(213.62);
        System.out.println(al);
    }
}