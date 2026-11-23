package Codeforces;

import java.util.Scanner;

public class InSearchOfConvenience_2275A {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int X0 = sc.nextInt();
            int Y0 = sc.nextInt();
            int R = sc.nextInt();

            for (int x = X0 - R; x <= X0 + R; x++) {
                int ySquare = R * R - (x - X0) * (x - X0);

                int yOffset = (int) Math.sqrt(ySquare);

                if (yOffset * yOffset == ySquare) {
                    int y1 = Y0 + yOffset;
                    System.out.println(x + " " + y1);
                    if (yOffset != 0) {
                        int y2 = Y0 - yOffset;
                        System.out.println(x + " " + y2);
                    }
                }
                break;
            }

        }
    }
}
