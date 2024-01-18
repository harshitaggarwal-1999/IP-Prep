package DP;

public class EditDistance {
    // recursive solution
     public int minDistanceRecursive(String s1, String s2) {
         if(s1.length() == 0){
             return s2.length();
         }

         if(s2.length() == 0){
             return s1.length();
         }
         int ans = 0;
         String ros1 = s1.substring(1);
         String ros2 = s2.substring(1);

         if(s1.charAt(0) == s2.charAt(0)){
             ans = minDistanceRecursive(ros1,ros2);
         }else{
             int f1 = 1+minDistanceRecursive(ros1, ros2); // replace case

             int f2 = 1 + minDistanceRecursive(ros1, s2); // addition case

             int f3 = 1 + minDistanceRecursive(s1, ros2); // removal case

             ans = Math.min(f1, Math.min(f2, f3));

         }
         return ans;
     }


    // DP iterative
    public int minDistanceIterative(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // seed
        dp[s1.length()][s2.length()] = 0; //  jab dono string hi empty hongi to matlab kuch nahi karne ka hai dono empty hai to dono ko same karne ke operations bhi 0 hi honge

        // j -> {0, s1.length()}
        // i -> {0, s2.length()}
        // in last row
        for(int j = s2.length()-1; j >= 0; j--){
            dp[s1.length()][j] = 1+dp[s1.length()][j+1]; //  last row me bharna hai
        }

        for(int i = s1.length()-1; i >= 0; i--){
            dp[i][s2.length()] = 1+dp[i+1][s2.length()]; // last col me bharna hai
        }

        for(int i = s1.length()-1; i >= 0; i--){
            for(int j = s2.length()-1; j >= 0; j--){

                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]; // same then just check for rest of string(ros)
                }else{
                    int f1 = 1 + dp[i+1][j+1]; // replace
                    int f2 = 1 + dp[i+1][j]; // add
                    int f3 = 1 + dp[i][j+1]; // remove

                    dp[i][j] = Math.min(f1, Math.min(f2, f3)); //  smallest btana hai toh minimum le lenge

                }
            }
        }
        return dp[0][0];
    }
}