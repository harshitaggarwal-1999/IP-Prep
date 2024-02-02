package DP;
import java.util.*;

public class SubsetSumEqualToK {
    public static boolean subsetSumToKBottomUp(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];
        // cell meaning : is making target possible if array element till idx are considered

        for(int i = 0; i < n; i++){ // target == 0 base case
            dp[i][0] = true;
            // if target is zero then for all indexes the value will be true
        }


        // if arr is less than and equal to k then we can include that element so mark that element true
        // The first row dp[0][] indicates that only the first element of the array is considered, therefore for the target value equal to arr[0], only cell with that target will be true, so explicitly set dp[0][arr[0]] =true, (dp[0][arr[0]] means that we are considering the first element of the array with the target equal to the first element itself). Please note that it can happen that arr[0]>target, so we first check it: if(arr[0]<=target) then set dp[0][arr[0]] = true.
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // direction (idx : 0 -> n-1) && (k : 0 -> k)
        for(int idx = 1; idx < n; idx++){
            for(int target = 0; target <= k; target++){
                boolean notTaken = dp[idx-1][target];
                boolean taken = false;
                if(target >= arr[idx]) taken = dp[idx-1][target-arr[idx]];

                dp[idx][target] = (taken || notTaken);
            }
        }

        return dp[n-1][k];
        // means : is making target equals to k possible considering all indexs of given array are considered with all possiblitites

    }
    public static boolean subsetSumToKTopDown(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k+1];

        // to mark dp array if visited or not we are initiating dp array with -1
        for(int[] subarr: dp){
            Arrays.fill(subarr, -1);
        }

        // dp cases
        // 1 -> true
        // 0 -> false
        // -1 -> not visited yet

        return f(n-1, k, arr, dp);
    }

    public static boolean f(int idx, int target, int[] arr, int[][] dp){

        // base case
        if(target == 0){
            dp[idx][target] = 1;
            return true;
            // if target is 0  this means that we don't need any more subsequences to make target to add in array
        }

        if(idx == 0){
            if(target-arr[0] == 0){
                dp[idx][target] = 1;
                return true;
            }else{
                dp[idx][target] = 0;
                return false;
            }
            // if idx is 0 but target is not yet 0 then just check if adding current array element (arr[0]) doesn't make target 0 then just return false and store 0 in dp array otherwise store 1 annd return true
        }

        // dp check
        if(dp[idx][target] != -1){
            boolean ans = (dp[idx][target] == 0)? false : true;
            return ans;

            // if dp for that index is already visited and then just return that value of dp as it is storing the answer
        }

        // recursion calls
        boolean notTaken = f(idx-1, target, arr, dp);
        // current element is not included in answer subsequent array  may be that particular thing can give answer

        boolean taken = false;
        if(target >= arr[idx]) taken = f(idx-1, target-arr[idx], arr, dp);
        // if current element is included in answer subsequent array may be that can give the answer here we are calling idx-1 because there is not asked that we can use that particular array elemtn twice or more number of times so once included we cannot include that array element

        // return ans
        boolean ans = taken || notTaken;
        dp[idx][target] = ((taken||notTaken) == true)? 1: 0;
        // if any of array element is taken or notTaken gives the answer true just return that but first store it in dp that dp[idx][target] = if((taken||notTaken) == true) store 1 else store 0

        return ans;
    }
}

