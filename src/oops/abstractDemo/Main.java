package oops.abstractDemo;

public class Main {
    public static void main(String[] args){
        Son son = new Son();
        son.career();
        Parent daughter = new Daughter();
        daughter.career();
        Parent.hello();
        son.normal();
    }
}