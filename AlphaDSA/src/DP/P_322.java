package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_322 {

    static  int INF ;
    public static void main(String[] args) {
        int[] coins = { 1,3,7,4};
        int amount = 11;
        INF = amount+31;
        System.out.println("Answer : " + coinChange(coins, amount));

        Map<String, Integer> map = new HashMap<>();
        System.out.println("Answer Just checking : " + coinChangeMemo(coins, map, amount, 0));
      
        System.out.println("Answer DP : " + coinChangeDP(coins, amount));
    }

    public static int coinChangeMemo(int coins[], Map<String, Integer> map, int amount, int i) {
        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length) {

            return INF;
        }
        String key = i + "_" + amount;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (coins[i] <= amount) {

            int ans1 = 1 + coinChangeMemo(coins, map, amount - coins[i], i);
            int ans2 = coinChangeMemo(coins, map, amount, i + 1);

            int result = Math.min(ans1, ans2);
            map.put(key, result);
            return map.get(key);
        } else {
            int exclude = coinChangeMemo(coins, map, amount, i + 1);
            map.put(key, exclude);
            return map.get(key);
        }
    }

    public static   int coinChangeDP(int coins[], int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
         for (int arr[] : dp) {
            System.out.println(Arrays.toString(arr));
            System.out.println("-------------------");
        }

        int result = solve(coins, amount, 0, amount, dp);

         for (int arr[] : dp) {
            System.out.println(Arrays.toString(arr));
            System.out.println("-------------------");
        }
        return result == Integer.MAX_VALUE-1 ? -1 : result;
    }

    public static  int solve(int coins[], int amount, int i, int target, int dp[][]) {
        if (target == 0) {
            return 0;
        }
        if (i >= coins.length) {
            return INF;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }

        if (coins[i] <= target) {
            int pick = 1 + solve(coins, amount, i, target - coins[i], dp);
            int notPick = solve(coins, amount, i + 1, target, dp);
            return dp[i][target] = Math.min(pick, notPick);
        } else {
            return dp[i][target] = solve(coins, amount, i + 1, target, dp);
        }
    }


    public static int coinChange(int[] coins, int amount) {
        int INFTY = INF;
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = INFTY;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j <= amount; j++) {

                int v = coins[i - 1];

                if (v <= j) {
                    int ans1 = 1 + dp[i][j - v];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.min(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (dp[coins.length][amount] == INFTY)
                ? -1
                : dp[coins.length][amount];
    }

}
