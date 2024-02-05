package DP.DP_on_subsequence;
import java.util.*;
import java.io.*;

public class countSubsetWithSumK {
    // finding the number of subsets with sum k
    public static int findWays(int arr[], int target){
        int n = arr.length;

        int[][] dp = new int[n][target+1];


        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        } // arr ka pehle element kuch bhi ho but target 0 ho chuka hai toh matlab usey naa lekr bhi ek tareeka hai answer bnanne ka issiliye dp[0][0] = 1;

        if(arr[0] == 0) dp[0][0] = 2; // arr ke pehla element 0 ho and target bhi 0 ho  to uss array ke first element yani ki 0 ko lekr aur na lekr dono tareeko se answer nikala jaa skata hai issiliye dp[0][0] = 2
        if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1; // abb is point me array ka pehle element na to 0  hai aur arr[0] ,= target ke to vo khud choose hokar answer de sakta hai to issiliye usey include karna jaruri hai issiliye dp[0][arr[0]] = 1 ye bata raha hai ki agar array ka pehla element hi dekha jae aur target arr[0]  ke barabar ho to usey choose karsakte ho besharte ki vo khud arr[0] se bada ho ya barabar ho


        // cell meaning for a particualr cell (dp[2][3]) this will tell how many ways to make subset if 2 elements of given array are consider to make target of value equals to 3

        // direction of flow (idx: 1 -> n-1) and ( target: 0-> target)
        for(int idx = 1; idx <= n-1; idx++){
            for(int amount = 0; amount <= target; amount++){
                int notTaken = dp[idx-1][amount];
                int taken = 0;
                if(amount >= arr[idx]) taken = dp[idx-1][amount-arr[idx]];

                dp[idx][amount] = (notTaken%mod + taken%mod)%mod;
            }
        }

        return dp[n-1][target];
    }

    public static int findWaysBottomUp(int arr[], int target){
        int n = arr.length;

        int[][] dp = new int[n][target+1];

        if(arr[0] == 0) dp[0][0] = 2; // arr ke pehla element 0 ho and target bhi 0 ho  to uss array ke first element yani ki 0 ko lekr aur na lekr dono tareeko se answer nikala jaa skata hai issiliye dp[0][0] = 2
        else dp[0][0] = 1; // arr ka pehle element kuch bhi ho but target 0 ho chuka hai toh matlab usey naa lekr bhi ek tareeka hai answer bnanne ka issiliye dp[0][0] = 1;
        if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1; // abb is point me array ka pehle element na to 0  hai aur arr[0] ,= target ke to vo khud choose hokar answer de sakta hai to issiliye usey include karna jaruri hai issiliye dp[0][arr[0]] = 1 ye bata raha hai ki agar array ka pehla element hi dekha jae aur target arr[0]  ke barabar ho to usey choose karsakte ho besharte ki vo khud arr[0] se bada ho ya barabar ho


        // cell meaning for a particualr cell (dp[2][3]) this will tell how many ways to make subset if 2 elements of given array are consider to make target of value equals to 3

        // direction of flow (idx: 1 -> n-1) and ( target: 0-> target)
        for(int idx = 1; idx <= n-1; idx++){
            for(int amount = 0; amount <= target; amount++){
                int notTaken = dp[idx-1][amount];
                int taken = 0;
                if(amount >= arr[idx]) taken = dp[idx-1][amount-arr[idx]];

                dp[idx][amount] = (notTaken%mod + taken%mod)%mod;
            }
        }

        return dp[n-1][target];
    }


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
}
