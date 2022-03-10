package oops.interfaces;

public class ElectricEngine implements Engine {
    public void start(){
        System.out.println("Electric engine start");
    }
    public void stop(){
        System.out.println("Electric engine stop");
    }
    public void acc(){
        System.out.println("accelerated with tesla power");
    }
}
