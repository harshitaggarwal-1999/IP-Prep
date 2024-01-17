class Solution {
    public int majorityElement(int[] nums) {
        int maxnum = nums[0];
        int maxnumfreq = 0;

        for(int i = 0; i < nums.length; i++){
            int currnum = nums[i];
            if(currnum == maxnum){
                maxnumfreq++;
            }else{
                maxnumfreq--;
                if(maxnumfreq == 0){
                    maxnum = currnum;
                    maxnumfreq = 1;
                }
            }
        }
        return maxnum;
    }
}