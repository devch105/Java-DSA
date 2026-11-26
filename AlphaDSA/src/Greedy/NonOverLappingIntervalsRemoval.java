package Greedy;

import java.util.Arrays;

public class NonOverLappingIntervalsRemoval {
    
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int ans = eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove : " + ans);
    }

      public static  int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)-> a[0]-b[0]);

        int left =0;
        int right =1;
        int count =0;
        while(right < intervals.length){
            int currStart = intervals[right][0];
            int currEnd = intervals[right][1];

            int nxtStart = intervals[left][0];
            int nxtEnd = intervals[left][1];


            if(currEnd <= nxtEnd){
                count++;
            }else if(currEnd > nxtEnd ){
                left++;
            }

            right++;
        }

        return count;
    }

}
