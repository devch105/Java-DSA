package algorithimPatterns.SlidingWindow;

import java.util.HashMap;

public class P_1658_MinimumOpsToReduceXtoZero {
    public static void main(String[] args) {
        int[] nums = { 3, 3, 2, 1, 1, 2 };
        int x = 5;
        System.out.println(" +ve "+minOperations(nums, x));
        System.out.println(" for All "+minOperationsTwo(nums, x));
    }

    // for +ve Numbers only
    public static int minOperations(int nums[], int k) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int remainingSum = totalSum - k;

        if (remainingSum < 0) {
            return -1;
        }
        if (remainingSum == 0) {
            return nums.length;
        }

        int left = 0, right = 0, currSum = 0, maxLen = -1;

        while (right < nums.length) {
            currSum += nums[right];

            while (currSum > remainingSum && left <= right) {
                currSum -= nums[left];
                left++;
            }
            if (currSum == remainingSum) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }


    public static  int minOperationsTwo(int nums[] , int k){
           int totalSum =0;
           for(int num : nums){
               totalSum += num;
           }
           int remainingSum = totalSum - k;
           // Continue with the rest of the logic

           HashMap<Integer, Integer> map = new HashMap<>();
           map.put(0, -1); // Initialize with sum 0 at index -1

           int currSum =0;
           int maxLen =-1;

           for(int i = 0; i < nums.length; i++){   
              currSum+=nums[i];

              int pending = currSum - remainingSum;
              if(map.containsKey(pending)){
                 maxLen = Math.max(maxLen, i - map.get(pending));
              }
              map.putIfAbsent(currSum, i);
            }
            return  maxLen == -1 ? -1 : nums.length - maxLen;
       }
}
