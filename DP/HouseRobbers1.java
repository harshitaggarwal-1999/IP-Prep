package DP;
import java.util.*;

public class HouseRobbers1 {
    public int robBottomUp(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        else if(n == 1) return nums[0];
        else {
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for(int i = 2; i < n; i++){
                int pick = nums[i]+dp[i-2];
                int notpick = dp[i-1];
                dp[i] = Math.max(pick, notpick);
            }
            return dp[n-1];
        }
    }

    public int robTopDown(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n-1, nums, dp);
    }

    public int f(int idx, int[] arr, int[] dp){

        // base cases
        if(idx == 0) return arr[0]; //  in this case the house just next to 0 that is house number 1(idx == 1) is not chosen so we have to add
        if(idx < 0) return 0;
        // dp check
        if(dp[idx] != -1){
            return dp[idx];
        }

        // recursion calls
        // pick and not pick
        // and as we have to pick the NOT adjacent houses this means that if we are picking we can't call function for n-1 and if we are not picking the current huse then we have to pick the next house(n-1)
        int pick = arr[idx]+f(idx-2, arr, dp);
        int notpick = 0 + f(idx-1, arr, dp);

        // return  ans

        return dp[idx] = Math.max(pick, notpick);


    }
}