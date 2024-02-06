package DP.DP_on_strings;
import java.util.*;
public class LongestCommonSubstring {
    public static int lcsBottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        int ans = 0;

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
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    ans = Math.max(dp[i][j], ans);
                }else{
                    // as this is not subsequence toh phir jab bhi nahi matching elements milenge toh just seedha seedha 0 daaldo and aage bado
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }
}
