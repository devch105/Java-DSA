package Greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatform {
    public static void main(String[] args) {
        int arrival[] = {900,940,950,1100,1500,1800};
        int departure [] = {910,1120,1130,1200,1900,2000};
        System.out.println("Answer : "+minimumPlatform(arrival, departure));
    }

    public static  int minimumPlatform(int arr[] , int dep[]){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform = 1;
        int result =1;
        int i=1, j=0;

        while(i<arr.length && j<dep.length){

            if(arr[i] <= dep[j]){
                platform++;
                i++;
            }else{
                platform--;
                j++;
            }
            result = Math.max(platform, result);
        }
        return  result;
    }
}
