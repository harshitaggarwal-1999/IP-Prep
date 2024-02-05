package DP.DP_on_subsequence;
import java.util.*;

// DP on number of ways
// in this we ar suppossed to find all the possible number of ways thus returning the number of ways possible to form that combination
public class CoinChange2 {
    public int f(int idx, int target, int[] coins, int[][] dp){
        // base case
        if(idx == 0){
            return dp[idx][target] = (target%coins[0] == 0)? 1:0;
            // this is done because if idx== 0 and coins array only elemetn is not able to completely divide this means that we have to return 0 as there is no way that it can be divided and 1 as it can be divided by that remaining element
        }

        // dp check
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        // recursion calls
        // as this question is of no. of ways we need to ask take and not take strategy
        int notTaken = f(idx-1, target, coins, dp);
        int taken = 0;
        if(coins[idx] <= target){
            // target is smaller than the element in the idx this means that there is no way the target can become 0 so just don't take that element
            taken = f(idx, target-coins[idx], coins, dp);
        }

        // return
        return dp[idx][target] = taken + notTaken;

    }

    public int changeTopDown(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] subarr : dp){
            Arrays.fill(subarr, -1);
            // we have to fill this -1 because our dp will be storing 0 as an answer so this thing can fail thus increasing the time complexity
        }
        return f(n-1, amount , coins, dp);
    }


    public int change(int target, int[] coins){
        int n = coins.length;

        int[][] dp = new int[n][target+1];

        for(int i = 0; i <= target; i++){
            if(i % coins[0] == 0){
                dp[0][i] = 1 ;
            }
        }
        // cell meaning : arr[1][2] : if only 2 (idx = 0, idx = 1) coins were used what is the no, of ways to make amount equals to 2

        // direction of filling left to right and top to bottom ( as the cell dp[n-1][target] tells if all coins were consider what is the no. of ways to make that given amount)

        for(int idx = 1; idx < n; idx++){
            for(int amount = 0; amount <= target; amount++){
                int notTaken = dp[idx-1][amount];
                int taken = 0;
                if(amount >= coins[idx])taken = dp[idx][amount-coins[idx]];

                dp[idx][amount] = taken+notTaken;
            }
        }
        return dp[n-1][target];
    }
}