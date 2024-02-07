package DP.DP_on_strings;
import java.util.*;

public class MakeInsertionsToMakeStringPalindromic {
    public int minInsertions(String s) {
        // this we will find the Longest Already palindromic substring then we will just do those operations for which it is not palindromic by just copying so that is (string.length)- LPS;
        int n = s.length();
        int longestPalindromicSubsequence = longestPalindromeSubseq(s);

        return n - longestPalindromicSubsequence;
    }

    public int longestPalindromeSubseq(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String revstr = sb.toString();
        return longestCommonSubsequenceBottomUp(str, revstr);
    }

    public int longestCommonSubsequenceBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        // base case cover
        // i == 0
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        // direction i : 1 -> n-1 && j : 1 -> m-1
        for(int i = 1; i <= n; i++){
            for(int j = 1;  j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];

                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];

    }

    public int longestCommonSubsequenceTopDown(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] subarr : dp){
            Arrays.fill(subarr, -1);
        }

        return f(n, m, s1, s2, dp);
    }

    public int f(int i, int j, String s1, String s2, int[][] dp){

        // base case
        // agar dono me se koi bhi string khtm hoti hai to just return 0 kyuki ab kuch bacha hi nahi compare karne liye
        if(i == 0 || j == 0){
            return 0;
        }

        // dp check
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // recursion calls
        // agar s1.charAt(i-1) and s2.charAt(j-1) same hai to use count karo then next i-1 and j-1 ke liye call kardo
        if(s1.charAt(i-1) == s2.charAt(j-1)) return dp[i][j] = 1 + f(i-1, j-1, s1, s2, dp);

        // agar same nahi hai toh pehle pehle vale me se exclude karke dekh and call karo then next vale ko exclude karke call karo , phir jo dono me se sabse bada ho usey return kardo dp me store karva kar
        dp[i][j] = Math.max(f(i-1, j, s1, s2, dp), f(i, j-1, s1, s2, dp));

        // return ans
        return dp[i][j];
    }
}