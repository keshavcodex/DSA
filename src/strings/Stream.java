package strings;

public class Stream {
    public static void main(String[] args){
        String a = "bzaccdah";
        skip(a);
    }

    private static void skip(String a) {
        skip("", a);
    }

    //    p = processed, up = unprocessed
    static void skip(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch == 'a') {
            skip(p, up.substring(1));
        } else {
            skip(p + ch, up.substring(1));
        }
    }
}
