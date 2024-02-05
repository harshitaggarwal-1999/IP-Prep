package DP.DP_on_strings;
import java.util.*;

public class longestIncreasingSubsequence  {
    public int lengthOfLIS(int[] nums){
        // O(nlogn) approach
        ArrayList<Integer> tail = new ArrayList<>();
        tail.add(nums[0]);

        for(int i = 0; i < nums.length; i++){
            int currelem = nums[i];

            if(currelem > tail.get(tail.size()-1)){
                // if last value of tail is greater than currelem just add it to the tail arraylist
                tail.add(nums[i]);
            } else {
                // else just do the binary search of the same in the tail array and as we are adding element in order this means that tail will always be sorted so binary search can be aplied

                // and as that element for sure won't be in the list this means that idx returning will be the negative and the idx which it needs to be placed to the just lesser element where it failed can be achieved by idx = -(idx+1) and set the tail at that idx with the nums[i];
                int idx = Collections.binarySearch(tail, nums[i]);
                if(idx < 0){
                    idx = -(idx+1);
                }

                tail.set(idx, nums[i]);
            }
        }
        //  in last return the tail.size(0) for the length and for the LIS we can return the tail array
        return tail.size();
    }

    public int lengthOfLIS1(int[] nums) {
        // O(n^2) approach
        int n = nums.length;
        int[] lis = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                lis[i] = 1;
                continue;
            }
            // because har element can be it's first element in it's own LIS answer
            lis[i] = 1;

            // fetch the values from every element in it's left and calculate it's LIS
            for(int idx = 0; idx < i; idx++){
                if(nums[idx] < nums[i]){
                    //take it's LIS and add 1 to that and update your LIS after comparing with your LIS
                    int newLIS = lis[idx];
                    lis[i] = Math.max(1+newLIS, lis[i]);
                }
            }
        }

        // calculate the max LIS
        int ans = 0;
        for(int i = 0 ;i < n; i++){
            ans = Math.max(lis[i], ans);
        }
        return ans;
    }
}