package Codeforces.contest.CP_1138_D3;

import java.util.Arrays;
import java.util.Scanner;

public class CQ_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();

            long rating[] = new long[n];
            for (int i = 0; i < rating.length; i++) {
                rating[i] = sc.nextInt();
            }

            System.out.println(maxJoyPoints(rating, n, k, p));

        }
    }

    public static long maxJoyPoints(long arr[], int n, int k, int p) {
        long total = 0;
        for (long x : arr) {
            total += x;
        }

        Arrays.sort(arr);

        long answer = total;

        for (int i = 0; i + k <= n; i += k) {
            long sum = 0;

            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum < p) {
                answer += p - sum;
            } else {
                break;
            }
        }
        return answer;
    }
}
