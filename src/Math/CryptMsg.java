package Math;

public class CryptMsg {
    static String cryptmsessage(String s) {

        int length = s.length();
        double root = Math.sqrt(length);
        int floor = (int) Math.floor(root);
        int ceiling = (int) Math.ceil(root);

        if (floor * ceiling < length) floor++;

        System.out.println(floor);
        System.out.println(ceiling);

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < ceiling; i++) {
            for (int j = 0; j < floor; j++) {
                int index = i + (j * ceiling);
                if (index < length) str.append(s.charAt(index));
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String s = "pleasesavemeytv";
        String output = "psvyleetesmvaae";
        String ans = cryptmsessage(s);

        if (ans.equals(output)) {
            System.out.println("Your ans is correct!");
        } else {
            System.out.println("test case failed!");
        }
        System.out.println("exp: " + output);
        System.out.println("ans: " + ans);
    }
}
