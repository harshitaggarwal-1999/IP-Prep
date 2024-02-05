package DP.Partition_DP;

public class MCM {

    public static void main(String[] args) {
        int[] arr = {4, 2 ,3, 5, 1};
//        int ans = MCMRecursion(arr, 0, arr.length-1);
//        int ans = MCMTD(arr, 0, arr.length-1, new int[arr.length][arr.length]);
        int ans = MCMBU(arr);
        System.out.println(ans);
    }

    public static int MCMRecursion(int[] arr,  int si, int ei){
        if(si+1 == ei){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = si+1; k <= ei-1; k++){
            int fp = MCMRecursion(arr, si, k);
            int sp = MCMRecursion(arr, k, ei);

            int sw = arr[si] * arr[k] * arr[ei];

            int total = fp + sp + sw;
            if(total < min){
                min = total;
            }
        }
        return min;
    }

    public static int MCMTD(int[] arr,  int si, int ei, int[][] dp){
        if(si+1 == ei){
            return 0;
        }

        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for(int k = si+1; k <= ei-1; k++){
            int fp = MCMTD(arr, si, k, dp);
            int sp = MCMTD(arr, k, ei, dp);

            int sw = arr[si] * arr[k] * arr[ei];

            int total = fp + sp + sw;
            if(total < min){
                min = total;
            }
        }
        dp[si][ei] = min;
        return min;
    }

    public static int MCMBU(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int slide = 1; slide <= n-1; slide++){
            for (int si = 0; si <= n-slide-1; si++){
                int ei = si+slide;

                if(si+1 == ei){
                    dp[si][ei] = 0;
                }
                if(dp[si][ei] != 0){
                    return dp[si][ei];
                }
                int min = Integer.MAX_VALUE;
                for(int k = si+1; k <= ei-1; k++){
                    int fp = dp[si][k];
                    int sp = dp[k][ei];

                    int sw = arr[si]* arr[k] * arr[ei];

                    int total = fp+sp+sw;

                    if(total < min){
                        min = total;
                    }
                    dp[si][ei] = min;
                }
            }
        }
        return dp[0][n-1];
    }

}
