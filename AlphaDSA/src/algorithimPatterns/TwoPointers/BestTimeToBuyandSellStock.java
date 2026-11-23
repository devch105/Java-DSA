package algorithimPatterns.TwoPointers;

public class BestTimeToBuyandSellStock {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 1 };
        System.out.println("Answer : " + bestTimetobuyandSellstock(arr));
    }

    public static int bestTimetobuyandSellstock(int nums[]) {
        int currItem = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currItem = Math.min(currItem, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - currItem);
        }
        return maxProfit;
    }
}
