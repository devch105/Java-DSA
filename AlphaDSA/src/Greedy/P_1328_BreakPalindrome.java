package Greedy;

public class P_1328_BreakPalindrome {

    public static void main(String[] args) {
        String palindrome = "abccba";
        String ans = breakPalindrome(palindrome);
        System.out.println("Lexicographically smallest string : " + ans);
    }

    public static String breakPalindrome(String str) {
        if (str.length() == 1) {
            return "";
        }

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return new String(arr);
            }
        }

        arr[arr.length - 1] = 'b';
        return new String(arr);
    }
}
