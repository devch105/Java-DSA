package Recursion;

import java.util.Scanner;

public class PowerOfFour {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        boolean result = power(n);
        System.out.println("Answer : " +result);
    }

    public static boolean power(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        return power(n / 4);
    }
}
