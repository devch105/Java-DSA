package Codeforces.contest.CP_1134_D2;

import java.util.Scanner;

public class CQ1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            sovle(n);
        }
    }

    public static void sovle(int n) {
        if (n < 4) {
            System.out.println(-1);
            return;
        }
        int base[] = { 6, 7, 5, 4, 3, 1, 2 };

        if (n == 4) {
            System.out.println("4 3 2 1");
            return;
        }
        if (n == 5) {
            System.out.println("4 5 1 2 3");
            return;
        }
        if (n == 6) {
            System.out.println("6 5 4 1 2 3");
            return;
        }
        if (n == 7) {
            System.out.println("6 7 5 4 1 2 3");
            return;
        }

        if (n > 7) {
            for (int x : base) {
                System.out.print(x + " ");
            }

            for (int i = 8; i <= n; i++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
