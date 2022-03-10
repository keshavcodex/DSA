package oops.generics;

import java.util.Arrays;
import java.util.List;

public class WildcardExample<T extends Number> {
    private Object[] data;
    private static int default_size = 10;
    private int size = 0;

    public WildcardExample() {
        this.data = new Object[default_size];
    }

    public void getList(List<Number> list) {
        //do something
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
        return (T) (data[--size]);
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
        WildcardExample<Float> al = new WildcardExample();
        al.add(61.2f);
        al.add(65.4f);
        System.out.println(al);
    }
}
