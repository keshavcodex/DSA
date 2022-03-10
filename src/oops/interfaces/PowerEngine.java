package oops.interfaces;

public class PowerEngine implements Engine {
    public void start(){
        System.out.println("Nitro boost enabled");
    }
    public void stop(){
        System.out.println("Nitro disabled");
    }
    public void acc(){
        System.out.println("Power engine on it's peek");
    }
}
