package DP.DP_1d;

public class MaximumProductSubarray {
    public int maxProduct(int[] arr) {
        int ans = Integer.MIN_VALUE;

        // this whole approach is based on thinking that answer can be in first part or in the second part of two subarrays
        // this can be solved by contradiction we will say that out answeer won't lie either in first subarray neither in second array but somewhere in between of them
        // case 1; -()- check for both -ve and +ve answer
        // case 2  +()+ check for both -ve and +ve answer
        // case 3  -()+ check for both -ve and +ve answer
        // case 4  +()- check for both -ve and +ve answer

        int cprod = 1;
        for(int i = 0; i < arr.length; i++){
            cprod *= arr[i];
            ans = Math.max(cprod, ans);
            if(cprod == 0){
                cprod = 1;
            }
        }

        cprod = 1;
        for(int i = arr.length-1; i >= 0; i--){
            cprod *= arr[i];
            ans = Math.max(cprod, ans);
            if(cprod == 0){
                cprod = 1;
            }
        }
        return ans;
    }
}