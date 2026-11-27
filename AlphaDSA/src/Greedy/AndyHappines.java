package Greedy;

import java.util.Arrays;

public class AndyHappines {

    public static void main(String[] args) {

        int joy[] = { 3, 9, 10, 9, 2, 1, 4 };
        int k = 2;

        System.out.println("Answer : " + maxHappinesRecursion(joy, k));
        System.out.println("Answer using DP : " + maxHappyDp(joy, k));
    }

    // bottom up dp

    public static int maxHappyDp(int arr[], int k) {
        int dp[][] = new int[arr.length + 2][k + 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int skip = dp[i + 1][j];
                int take = arr[i] + dp[i + 2][j - 1];

                dp[i][j] = Math.max(skip, take);
            }
        }
        for(int ar[] : dp){
            System.out.println("-> "+Arrays.toString(ar));
        }
        return dp[0][k];
    }

    public static int maxHappinesRecursion(int arr[], int k) {
        return solve(arr, 0, k);
    }

    public static int solve(int arr[], int i, int target) {
        if (i >= arr.length || target == 0) {
            return 0;
        }

        int skip = solve(arr, i + 1, target);
        int take = arr[i] + solve(arr, i + 2, --target);

        return Math.max(skip, take);
    }

}
