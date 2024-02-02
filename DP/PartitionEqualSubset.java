package DP;

public class PartitionEqualSubset  {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        // calculate the sum
        for(int i = 0 ;i < n; i++){
            sum+=nums[i];
        }
        // if sum is odd then it's not possible to break it into two equal halves so if sum is odd return false
        if(sum%2 != 0){
            return false;
        }
        //  so now question boils down to find the subset sum equal to the half of the sum of whole array
        // because if that is possible then left over element will form the second subset with their sum = target
        int target = sum/2;

        boolean[][] dp = new boolean[n][target+1];

        // base cases
        for(int i = 0; i < n; i++){ // target == 0 base case
            dp[i][0] = true;
        }

        if(nums[0] <= target){ // idx == 0 base case because only first element of nums can reduce the target only if the first element of nums is less than or equal to 0
            dp[0][nums[0]] = true;
        }

        for(int idx = 1; idx < n; idx++){
            for(int amount = 0; amount <= target; amount++){
                boolean notTaken = dp[idx-1][amount];

                boolean taken = false;
                if(amount >= nums[idx]) taken = dp[idx-1][amount-nums[idx]];

                dp[idx][amount] = (taken||notTaken);
            }
        }
        return dp[n-1][target];
    }
}