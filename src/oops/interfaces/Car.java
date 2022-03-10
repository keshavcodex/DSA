package oops.interfaces;

public class Car implements Engine, Brake{
    int a;

    @Override
    public void brake() {
        System.out.println("I like disc brake");
    }

    @Override
    public void start() {
        System.out.println("started moving");
    }

    @Override
    public void stop() {
        System.out.println("car ruk gya");
    }

    @Override
    public void acc() {
        System.out.println("op speed");
    }

}