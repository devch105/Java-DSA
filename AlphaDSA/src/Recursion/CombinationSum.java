package Recursion;

import java.util.ArrayList;

public class CombinationSum {

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5 };
        int target = 6;
        ArrayList<ArrayList<Integer>> result = combinationSum(arr, 0, target);
        System.out.println(result); // Output: [[2, 2, 2], [2, 4]]
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int arr[], int i, int target) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        totalWays(arr, i, target, inner, outer);
        return outer;
    }

    public static void totalWays(int arr[], int i, int target, ArrayList<Integer> aux,
            ArrayList<ArrayList<Integer>> result) {
        // Base case: stop when out of bounds
        if (i >= arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(aux));
            }
            return; // Added return to prevent ArrayIndexOutOfBoundsException
        }

        // Choice 1: Pick the current element (if it fits)
        if (arr[i] <= target) {
            aux.add(arr[i]);
            totalWays(arr, i, target - arr[i], aux, result);
            aux.remove(aux.size() - 1); // Backtrack
        }

        // Choice 2: Always explore skipping the current element
        totalWays(arr, i + 1, target, aux, result);
    }
}
