package DP.DP_on_subsequence;
import java.util.*;

// DP on subsequence
// in this question we are supposed to find minimum number of coins used to make the target if possible return answer otherwise return -1
public class coinChange {

    public int coinChangeTopDown(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] subarr: dp){
            Arrays.fill(subarr, -1);
        }

        int ans = f(n-1, coins, amount, dp);

        if(ans >= (int)1e9){
            return -1;
        }
        return ans;
    }


    public int f (int idx, int[] coins, int target, int[][] dp){ // tells no. of minimum coin used to make the target with the given denominations with infinite supply
        // base case
        if(idx == 0){
            if(target % coins[idx] == 0){
                dp[idx][target] = (target/coins[idx]);
                return target/coins[idx];
            }else{
                dp[idx][target] = (int)1e9;
                return (int)1e9;
            }
        }

        // dp checks
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        // recursion calls
        // take and nottake strategy as we will make sure first the coin is taken then the coin is not taken
        int notTaken = 0+f(idx-1, coins, target, dp);
        // here we wont include this coin this means that that particular coin should be skipped

        int taken = (int)1e9;
        if(target >= coins[idx]) taken = 1+f(idx, coins, target-coins[idx], dp);
        // as that particular value is taken so that means that we firsat need to add 1 as that particular con is counted and then make a call for same idx but with lesser target
        // answer return
        dp[idx][target] = Math.min(notTaken, taken);
        return dp[idx][target];
    }

    public int coinChangeBottomUp(int[] coins , int target){
        int n = coins.length;
        int[][] dp = new int[n][target+1];

        // minimum number of coin used when just one denomination(coins[0]) was considered for all valuse ranging from 0 to targets
        for(int i = 0; i <= target; i++){
            if(i%coins[0] == 0){
                dp[0][i] = (i/coins[0]);
            }else{
                dp[0][i] = (int)1e9;
            }
        }

        // direction of flow will be from top to bottom for a particular column and left to right for a particular row
        for(int idx = 1; idx < n; idx++){ // iteration over all rows
            for(int amount = 0;  amount <= target; amount++){ // iterating over all columns

                int notTaken = 0+dp[idx-1][amount];

                int taken = (int)1e9;
                if(amount >= coins[idx]) {
                    taken = 1+dp[idx][amount-coins[idx]];
                }

                dp[idx][amount] = Math.min(taken, notTaken);
            }
        }
        int ans = dp[n-1][target];
        if(ans == (int)1e9){
            return -1;
        }
        return ans;
    }


}
