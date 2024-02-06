package DP.DP_on_strings;
import java.util.*;
public class PrintLongestCommonSubsequence {

    public static String findLCSBottomDown(int n, int m, String s1, String s2){
        String[][] dp = new String[n+1][m+1];
        for(int i = 0; i<= n; i++){
            dp[i][0] = "";
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = "";
        }

        // direction i: 1 -> n && j: 1 -> m
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    String recString = dp[i-1][j-1];
                    StringBuilder sb = new StringBuilder();
                    sb.append(s1.charAt(i-1));
                    sb.append(recString);
                    dp[i][j] = sb.toString();
                }

                String recString1 = dp[i-1][j];
                String recString2 = dp[i][j-1];

                if(recString1.length() > recString2.length()){
                    dp[i][j] = recString1;
                }else{
                    dp[i][j] = recString2;
                }
            }
        }
        return dp[n][m];
    }
    public static String findLCSTopDown(int n, int m, String s1, String s2){
        // Write your code here.
        String[][] dp = new String[n+1][m+1];
        for(String[] subarr : dp){
            Arrays.fill(subarr, "-1");
        }

        return f(n, m, s1, s2, dp);
    }

    public static String f(int i, int j, String s1, String s2, String[][] dp){
        // base case
        // when i and j are 0 this means that both string or either of one string has been traversed completely sp just return empty string
        if(i == 0|| j == 0) return "";

        // dp check
        if(dp[i][j] != "-1"){
            return dp[i][j];
        }

        // recursive calls
        // if both are equal then just add the curr char and then add the the last rec recieved LCS string(as it is pickd so just pass i-1, j-1)
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            String recString = f(i-1, j-1, s1, s2, dp);
            StringBuilder sb = new StringBuilder();
            sb.append(s1.charAt(i-1));
            sb.append(recString);
            return dp[i][j] = sb.toString();

        }

        // now they are not equal so just check by ecluding element from one string and fetch LCs then same for second string
        String recString1 = f(i-1, j, s1, s2, dp);
        String recString2 = f(i,j-1, s1, s2, dp);

        // which of these string recieved from recursion whose length is longer just return that string
        if(recString1.length() > recString2.length()){
            return dp[i][j] = recString1;
        }else{
            return dp[i][j] = recString2;
        }
    }
}