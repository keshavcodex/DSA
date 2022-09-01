package strings;

public class Stream2 {
    public static void main(String[] args){
        String a = "bzaccdappleh";
//        System.out.println(skip(a));
        System.out.println(skipApple(a));
        System.out.println(skipAppNotApple(a));
    }

    //    p = processed, up = unprocessed
    private static String skip(String up) {
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }
    private static String skipApple(String up) {
        if(up.isEmpty()){
            return "";
        }
        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        } else {
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
    private static String skipAppNotApple(String up) {
        if(up.isEmpty()){
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
}
