package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSubsets {
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>() {{ add(1); add(2); add(3); }};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsets(arr, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr, int currIndex, ArrayList<Integer> currSubset, ArrayList<ArrayList<Integer>> result) {
        if (currIndex == arr.size()) {
            result.add(new ArrayList<>(currSubset));
            return result;
        }

        // Include the current element
        currSubset.add(arr.get(currIndex));
        subsets(arr, currIndex + 1, currSubset, result);

        // Exclude the current element
        currSubset.remove(currSubset.size() - 1);
        subsets(arr, currIndex + 1, currSubset, result);

        return result;
       
    }

   
}
