class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0; // i se k tak sab region unknown
        // 0 se j-1 tak 0s ka region
        int j = 0; // j se i-1 tak 1s ka region
        int k = n-1; // k se n tak 2s ka region
        while(i <= k){
            int currNum = nums[i];
            if(currNum == 0){
                // swap i and j
                // j++, i++
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                i++;

            }else if(currNum == 1){
                // i++
                i++;
            }else{
                // swap i k because at k there is gauranteed 2
                // k--

                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;

                k--;
            }
        }
    }


}