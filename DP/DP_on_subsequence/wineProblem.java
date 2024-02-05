package DP.DP_on_subsequence;

public class wineProblem {

    public static void main(String[] args) {
        int[] arr = {2 , 3 , 5 , 1, 4};
//        int ans = WPTD(arr, 0, 4, new int[arr.length][arr.length]);
        int ans = WPBU(arr);
        System.out.println(ans);
    }

    public static int maxProfit(int[] arr, int si, int ei, int y){
        if(arr.length == 0) return 0;
        if(si > ei){
            return 0;
        }

        int maxProfitIfLeftSell = maxProfit(arr, si+1, ei, y+1) + arr[si]*y;
        int maxProfitIfRightSell = maxProfit(arr, si, ei-1, y+1) + arr[ei]*y;

        int max = Math.max(maxProfitIfLeftSell, maxProfitIfRightSell);

        return max;
    }

    public static int WPTD(int[] arr, int si, int ei, int[][] dp){
        int y = (arr.length - (ei-si+1)) + 1; // y = sell + 1 // sell = arr.length-(ei-si+1)

        // base case
        if(si == ei){
            return arr[si]*y;
        }

        // dp
        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        // recursion calls -> recursion calls + which bottle sold and year
        int start = WPTD(arr, si+1, ei, dp) + arr[si]*y;
        int end = WPTD(arr, si, ei-1, dp) + arr[ei]*y;

        int ans = Math.max(start, end);
        dp[si][ei] = ans;

        return ans;
    }

    public static int WPBU(int[] arr){
        int n = arr.length;

        int[][] dp = new int[n][n]; // because two things are changing si and ei

        // note all the values in 2-d array where ei > si should not be calculated and all the values which are si == ei are the base values means which are the smaller problems which needs to be solved to solve the bigger problems where we are computing our answer for whole arr
        // note: each block in 2-d array shows "maximum profit by selling that ranges wine bottles for a particular year"

        for(int slide = 0; slide <= n-1; slide++){
            for(int si = 0; si <= n-slide-1; si++){
                int ei = si+slide;
                int yr = arr.length - (ei-si+1)+1;
                if(si == ei){
                    dp[si][ei] = arr[si]*yr;
                }else {

                    int start = dp[si + 1][ei] + arr[si] * yr;
                    int end = dp[si][ei - 1] + arr[ei] * yr;

                    int ans = Math.max(start, end);
                    dp[si][ei] = ans;
                }
            }
        }

        return dp[0][n-1];

    }
}