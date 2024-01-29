package Arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = Integer.MIN_VALUE;

        int currcount = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currcount++;
            }else{
                currcount = 0;
            }

            maxcount = Math.max(currcount, maxcount);
        }
        return maxcount;
    }
}
