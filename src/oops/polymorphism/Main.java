package oops.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        Circle circle = new Circle();
        Shapes circle2 = new Circle();

        shapes.area();
        circle.area();
    }
}
