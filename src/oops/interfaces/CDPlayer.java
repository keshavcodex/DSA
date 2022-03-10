package oops.interfaces;

public class CDPlayer implements Media{
    @Override
    public void start() {
        System.out.println("Hit the music");
    }

    @Override
    public void stop() {
        System.out.println("Music stopped");
    }
}

