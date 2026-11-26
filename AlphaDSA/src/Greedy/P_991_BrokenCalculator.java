package Greedy;

public class P_991_BrokenCalculator {
    
    public static void main(String[] args) {
        int startValue = 5;
        int target = 8;
        int ans = brokenCalc(startValue, target);
        System.out.println("Minimum number of operations : " + ans);
    }

    public static int brokenCalc(int start , int target){
        int count =0;

        while(target != start){
            if(target%2 == 0 && target > start){
                target/=2;
            }else{
                target++;
            }
            count++;
        }
        return count;
    }
}
