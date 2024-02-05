package DP.DP_on_strings;

public class LongestCommonSubsequenceLCS {

    public int longestCommonSubsequenceRecursive(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }
        int count = 0;
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if(s1.charAt(0) == s2.charAt(0)){
            count  = 1 + longestCommonSubsequenceRecursive(ros1, ros2);
        }else{
            int f1 = longestCommonSubsequenceRecursive(ros1, s2);
            int f2 = longestCommonSubsequenceRecursive(s1, ros2);

            count  = Math.max(f1, f2);
        }

        return count;
    }

    // DP Edit
    public int longestCommonSubsequenceIterative(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // seed
        dp[s1.length()][s2.length()] = 0;

        for(int i = s1.length(); i >= 0; i--){
            for(int j = s2.length(); j >= 0; j--){
                if(i == s1.length() || j == s2.length()){
                    // as iss point par ek me kuch hoga aur ek empty string hogi to unn dono ka lcs is always 0
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i) == s2.charAt(j)){
                    // agar dono characters same hai to matlab diagonal me jo hoga uski lcs + apka 1 milkar answer denge
                    dp[i][j] = 1 + dp[i+1][j+1];
                }else{
                    // agar dono characters alag hai toh kya pata kisi string me ek ko include na karke answer aa raha ho ya pohir doosri string me se ek ko na include karke answer aa raha ho
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}