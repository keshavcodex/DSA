package oops.interfaces;

public class Main {
    public static void main(String[] args){
/*
        Engine car = new Car();
//        car.a; //we can't access this,
//        accessing depends on Reference type
//        and which version to access,
//        depends on object types;
        car.acc();
        car.start();
        car.stop();
        CDPlayer carMedia = new CDPlayer();
        carMedia.stop();
        PowerEngine pe = new PowerEngine();
        pe.start();
        pe.acc();
*/
        NiceCar nc = new NiceCar();
        nc.start();
        nc.acc();
        nc.stop();
        nc.startMusic();
        nc.upgradeEngine();
        nc.start();
        nc.stopMusic();
        nc.acc();
        nc.stop();
    }
}
