package Greedy;

public class GasStation {
    
    public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost ={3, 4, 5, 1, 2};
    
    System.out.println("Answer : "+canCompleteCircuit(gas, cost));
    System.out.println("Answer With Greedy : "+greedy(gas, cost));
    }


    public static  int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas  = 0;
        
        for(int i=0; i<gas.length; i++){
             if(gas[i]<cost[i]){
                continue;
             }

             int j = (i+1)%gas.length;
             int gasOnIStation = gas[i];
             int costfromMovingIStation = cost[i];
             int gasEarnAtJStation = gas[j];
             currGas = gasOnIStation-costfromMovingIStation+gasEarnAtJStation;

             while(j!=i){
                if(currGas < cost[j]){
                    break;
                }
              int costfromMovingJStation = cost[j];
              j= (j+1)%gas.length;
              int gasEarnInNextStation = gas[j];
              currGas = currGas -costfromMovingJStation +gasEarnInNextStation;
             }
             if(i==j){
                return  i;
             }     
        }
        return  -1;
    }
    

    public static  int greedy(int gas[] , int cost[]){
          int totalGas =0;
          int totalCost =0;
          for(int i =0; i<gas.length; i++){
              totalCost+=cost[i];
              totalGas+=gas[i];
          }
          if(totalGas < totalCost){
            return  -1;
          }

          int total =0;
          int result =0;

          for(int i=0; i<gas.length; i++){
             total += gas[i]-cost[i];

             if(total<0){
              total =0;
              result=i+1;
            }
            
          }
          return result;
    }

}
