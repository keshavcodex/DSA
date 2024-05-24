package DynamicProgramming;

import java.util.ArrayList;

public class FIllZeroOne {
    ArrayList<String> list = new ArrayList<>();

    void fillZero(int n, String ans, long maxTime) {
        if (maxTime < System.currentTimeMillis()) {
            return;
        }
        else if (n == ans.length()) {
            list.add(ans);
            return;
        }
        else if (!ans.isEmpty() && ans.charAt(ans.length() - 1) == '1') {
            fillZero(n, ans + '0', maxTime);
        } else {
            fillZero(n, ans + '0', maxTime);
            fillZero(n, ans + '1', maxTime);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        FIllZeroOne obj = new FIllZeroOne();
        for (int i = 1; i <= 10; i++) {
            obj.list.clear();
            obj.TLECheck(i);
        }

    }

    private void TLECheck(int n) {
        long start = System.currentTimeMillis();
        long timeLimit = 100;
        fillZero(n, "", start + timeLimit);
        long end = System.currentTimeMillis();
        long elaspedTime = end - start;
        if (elaspedTime > timeLimit) {
            System.out.println("Time Limit Exceeded!! ");
        } else {
//            System.out.println(list);
//            System.out.println("Total execution time: " + elaspedTime + "ms");
            System.out.println("Count: " + list.size());
        }
    }
}
