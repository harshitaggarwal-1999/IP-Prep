package DP;
import java.util.*;

public class RodCuttingLeetcode {
    public int minCost(int n, int[] cuts) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 0; i < cuts.length; i++){
            arr.add(cuts[i]);
        }
        arr.add(n);

        int[][] dp = new int[cuts.length+1][cuts.length+1]; // because we will be needing the changing variable and cuts.length that's why we need to add cuts.length+1 arr
        for(int i = 0; i < cuts.length+1; i++){
            int[] currarr = dp[i];
            Arrays.fill(currarr, -1);
        }

        Collections.sort(arr);
        int i = 1, j = cuts.length;
        int ans = mincosthelper(i, j, arr, dp);

        return ans;
    }


    public int mincosthelper(int i , int j, ArrayList<Integer> cuts, int[][] dp){
        if( i > j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;

        for(int idx = i; idx <= j; idx++){
            int cost = cuts.get(j+1) - cuts.get(i-1); // by doing this we are calculatiing our cost
            int fp = mincosthelper(i, idx-1, cuts, dp); //  checking for the cost for the cuts which are in the left of the selected idx
            int sp = mincosthelper(idx+1, j, cuts, dp); // checking for the cost for the cuts which are in the right of the selected idx

            int total = cost+fp+sp;
            min = Math.min(total, min);
        }

        dp[i][j] = min;
        return min;


    }
}