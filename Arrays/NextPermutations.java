class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        // FIrstly i need to find the breakpoint point in the array
        int idx = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;  // break point is found at this location
                break;
            }
        }

        // if idx == -1 this means that no bigger number can be achieved just pass the sorted array(reverse in this case as whole array was just in decreasing order) BIG BRAINS TIME

        if(idx == -1){
            //reverse
            int i = 0, j = n-1;
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            return;
        }

        // now we have find the break point now we need to find the just greater number in the remaining array so that those can be swapped 2 1 5 4 3 0 0 
        // here we will start from ending because the array is already sorted here  and in decreasing order so traversing frommthe end will make our things easier to compare
        for(int i = n-1; i >= 0; i--){
            if(nums[i] > nums[idx]){
                // swap nums[i]  & nums[idx]
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // now we have the bigger number but we want just bigger so just reverse the array because we know that the rest of array will always be sorted in decreasing order and even after swappint the array will be still decreasingly sorted which means that we just need to reverse the array beyond the break point idx
        int i = idx+1;
        int j = n-1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}