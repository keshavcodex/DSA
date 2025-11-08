package helper;

public class Timer {
    static double s = 0;
    static double e = 0;
    public static void start(){
        s = System.currentTimeMillis();
    }
    public static void end(){
        e = System.currentTimeMillis();
        printTime(s, e);
    }
    public static void printTime(double start, double end){
        System.out.println("Time taken: " + (end - start) + " ms.");
    }
    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000)); // convert seconds to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupted status
        }
    }
}
