package oops.interfaces.extendDemo2;

public interface A {
    default void fun(){
        System.out.println("I am in A");
    }

    static void greeting() {
        System.out.println("Hey i am static method saying Good Morn");
    }
}
