package DP;
import java.util.*;

public class OnesAndZeroes {
    public int findMaxFormBottomUP(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                String currstr = strs[0];
                int currOne = countones(currstr);
                int currZero = currstr.length()-currOne;

                if(currZero <= i && currOne <= j){
                    dp[0][i][j] = 1;
                }
            }
        }

        for(int idx = 1; idx < len; idx++){

            for(int currzero = 0; currzero <= m; currzero++){

                for(int currone = 0; currone <= n; currone++){

                    String currstr = strs[idx];
                    int currOne = countones(currstr);
                    int currZero = currstr.length()-currOne;

                    int pick = 0;
                    if(currOne <= currone && currZero <= currzero){
                        pick = 1+dp[idx-1][currzero-currZero][currone-currOne];
                    }

                    int notpick = dp[idx-1][currzero][currone];
                    dp[idx][currzero][currone] = Math.max(pick, notpick);

                }
            }
        }
        return dp[len-1][m][n];
    }

    public int findMaxFormTopDown(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m+1][n+1];

        for(int[][] arr: dp){
            for(int[] row: arr){
                Arrays.fill(row, -1);
            }
        }

        return f(len-1, strs, m, n,  dp);

    }

    public int f(int idx , String[] arr, int m, int n, int[][][] dp){

        // System.out.println("idx -> "+idx+" , m -> "+ m + " , n -> "+ n);

        // base case

        // so as to reduce what wrong we have counted to which is making our m or n or both negative
        if(m < 0){
            return -1;
        }
        if(n < 0){
            return -1;
        }

        //when we are at index 0 the largest subset with m zeros and n ones will be the count of ones and zeros in that string
        if(idx == 0){
            String currstr = arr[0];
            int currOne = countones(currstr);
            int currZero = currstr.length()-currOne;
            //zeros and ones are valid return 1,else return 0
            // here if curr string has either count of one greather than n or count of zero greater than m in both cases we won't count anything so return 0; else return 1 as it will be countable
            if(currOne > n || currZero > m){
                return 0;
            }
            return 1;
        }

        // dp check
        if(dp[idx][m][n] != -1){
            return dp[idx][m][n];
        }

        // recursive calls
        String currstr = arr[idx];
        int currOne = countones(currstr);
        int currZero = currstr.length()-currOne;

        // if we will pick the current string then we will add the string to our subset and then we will call for rest of string by passing idx-1 and m and n updated values
        int pick = 1 + f(idx-1, arr, m-currZero, n-currOne, dp);
        int notpick = f(idx-1, arr, m, n, dp);

        // storing values in DP
        dp[idx][m][n] = Math.max(pick, notpick);

        // return ans
        return dp[idx][m][n];
    }

    public int countones(String str){
        int cnt = 0;
        char[] arr = str.toCharArray();
        for(char ch : arr){
            if(ch == '1') cnt++;
        }
        return cnt;
    }
}
