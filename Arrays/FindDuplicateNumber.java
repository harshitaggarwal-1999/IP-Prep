class Solution {
    public int findDuplicate(int[] nums) {

        // here we will use floyd cycle to determine the duplicate number because thats the poiunt where our duplicate number will be (their intersection point) 
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}