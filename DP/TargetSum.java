package DP;
import java.util.*;

public class TargetSum {

    // finding number of ways to find the subset with sum k
    public static int findWaysTopDown(int num[], int tar) {
        // Write your code here.
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] subarr: dp){
            Arrays.fill(subarr, -1);
        }
        return f(num, n-1, tar, dp);
    }
    static int mod = 1000000007;

    public static int f(int[] arr, int idx, int target, int[][] dp){

        if(idx == 0){
            // here if arr[0] is equal to 0 then if sum == 0 then either we can take it or not take it both ways it can give answer so we have to return 2
            if(target == 0 && arr[0] == 0) return 2;

            // here if target is 0 or target is equal to the only value left in array this means that we can complete this by not taking in case when sum is 0 and by taking the currval in case of target == arr[0] so in both cases we need to return 1 individually
            if(target == 0 || target == arr[0]) return 1;

            // rest all other cases just return 0
            return 0;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        // nottaken : humne vo vala element array ka count nahi karna na hi include karna hai to target ko kam nahi karenge
        int notTaken = f(arr, idx-1, target, dp);


        // taken: humne current element ko include karna hai toh usski value ko pehle check karenge ki vo target se ya toh cota hona chaiye ya phir uske equal tabhi ocunt karenge otherwise nahi aur jab count karenge to uski value ko targte me se reduce kardenge
        int taken = 0;
        if(target >= arr[idx]) taken = f(arr, idx-1, target-arr[idx], dp);

        dp[idx][target] = (taken%mod+notTaken%mod)%mod;

        return dp[idx][target];

    }

    // finding the number ways to divide the whole array into two subsets with difference between the two subset is 'd'
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int totalsum = 0;
        for(int i = 0; i < n; i++){
            totalsum+= arr[i];
        }

        // totalsum -d cannot be negative as sum cannot be negative  or (totalsum-d)%2 != 0 matlab even nahi hai toh divide by 2 karte hi vaue fractional hogi toh vo show nahi hogi so issiliye uska even hona bahut jaruri hai dono me se agar ek bhi case hai to return 0 kardo

        if(totalsum-d < 0 || (totalsum-d) % 2 != 0)return 0;

        return findWaysTopDown(arr, ((totalsum-d)/2));
    }

    //  it is nothing but finding the number of ways to divide whole array into two subset in such a way that difference between those two subsets is equal to 'target'
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        return countPartitions(n, target, nums);
    }
}