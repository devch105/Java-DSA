package Codeforces;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class DidNotGotToPrint {

    static HashSet<Integer> result = new HashSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            didNotGotToPrint(s, n);
            System.out.println((Math.abs(result.size() - n)));
            for (int i = 1; i <= n; i++) {
                if (!result.contains(i)) {
                    System.out.print(i + " ");
                }
            }
            result.clear(); // Clear the set for the next test case
        }
    }

    public static HashSet<Integer> didNotGotToPrint(String s, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int j = i - 1;
            if (s.charAt(j) == '1') {
                // stack push
                stack.push(i);
            } else if (s.charAt(j) == '2') {
                // stack pop
                if (!stack.isEmpty()) {
                    int print = stack.pop();
                    // System.out.println("Printed: "+ print);
                    result.add(print);
                } else {
                    // System.out.println("Printed /Empty i: "+i);
                    result.add(i);
                }
            } else if (s.charAt(j) == '3') {
                // print i
                // System.out.println("Printed: "+ i);
                result.add(i);
            }
        }
        return result;
    }
}
