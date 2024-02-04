package DP;

public class ClimbStairs {
    public int climbStairsTopDown(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        return f(n, dp);
    }

    public int f(int n, int[] dp){
        if(n == 0)return 1;
        // if(n<0) return 0;
        if(dp[n] != 0){
            return dp[n];
        }
        int onestep = f(n-1, dp);
        int twosteps = 0;
        if(n > 1) twosteps = f(n-2, dp);

        dp[n] = onestep+twosteps;
        return dp[n];
    }

    public int climbStairsBottomUp(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}