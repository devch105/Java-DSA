package Recursion;

import java.util.Scanner;

public class PowerOfThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = scanner.nextInt();
        boolean result = powerOfThree(n);
        System.out.println("Answer : " + result);
    }

    public static boolean powerOfThree(int n) {
       if(n==1){
        return true;
       }

       if(n % 3 != 0){
        return false;
       }
        return powerOfThree(n / 3);
    }
}
