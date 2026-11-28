package Greedy;

import java.util.Arrays;

public class P_179 {

    public static void main(String[] args) {

        int nums[] = { 3, 30, 34, 5, 9 };

        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        System.out.println("Array before sort : " + Arrays.toString(array));

        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));

        System.out.println("Array After sort : " + Arrays.toString(array));
        String str = "";
        for (String srr : array) {
            str+= srr;
        }
        System.out.println(str);
    }
}
