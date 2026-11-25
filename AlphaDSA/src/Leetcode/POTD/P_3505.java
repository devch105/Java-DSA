package POTD;

public class P_3505 {

    // Problem: https://leetcode.com/problems/number-of-ways-to-make-a-fair-array/

    public static void main(String[] args) {

        int arr[] = { 5, -2, 1, 3, 7, 3, 6, 4, -1 };
        int k = 2;
        int x = 3;
        System.out.println(seprateMethod(arr, k, x));
    }

    public static int seprateMethod(int arr[], int k, int x) {

        java.util.NavigableMap<Integer, Integer> left = new java.util.TreeMap<>();
        java.util.NavigableMap<Integer, Integer> right = new java.util.TreeMap<>();

        return 0;
    }

}
