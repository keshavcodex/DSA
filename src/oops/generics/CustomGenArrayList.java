package oops.generics;

import java.util.Arrays;

public class CustomGenArrayList<T> {
    private Object[] data;
    private static int default_size = 10;
    private int size = 0;

    public CustomGenArrayList() {
        this.data = new Object[default_size];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T) (data[--size]);
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
        CustomGenArrayList<String> al = new CustomGenArrayList();
        al.add("nice");
        al.add("cool");
        System.out.println(al);
    }
}

