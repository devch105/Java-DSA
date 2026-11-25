package Codeforces;

import java.util.Scanner;

public class PerfectSandwiches2276A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int max = -1;
        while (t-- > 0) {
            int a = sc.nextInt(); // cheese
            int b = sc.nextInt(); // sausage
            System.out.println(perfectSandwiches(a, b));
        }
    }

    public static int perfectSandwiches(int a, int b) {
        if (a <= b || b == 0) {
            return -1;
        }
        int diff = Math.abs(a - b);
        int sandwiches = Math.min(diff, b);

        return sandwiches;
    }
}
