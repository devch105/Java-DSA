package Greedy;

import java.util.Arrays;

public class BagofTokens {
    public static void main(String[] args) {
        int[] tokens = new int[]{100};
        int P = 50;
        int ans = bagOfTokensScore(tokens, P);
        System.out.println("Maximum score : " + ans);
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        int score = 0;
        int maxScore = 0;
        int left = 0;
        int right = tokens.length - 1;

        Arrays.sort(tokens);

        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                P += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}
