package Codeforces.contest.CP_1134_D2;

import java.util.*;

public class CQ2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();

            int zeros = 0;
            int ones = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            int small = Math.min(zeros, ones);

            small = Math.max(0, small - k);

            int large = n - small;

            long ans = 1L
                    + (long) small * (small + 1) / 2
                    + (long) large * (large + 1) / 2;

            System.out.println(ans);
        }

        sc.close();
    }
}

