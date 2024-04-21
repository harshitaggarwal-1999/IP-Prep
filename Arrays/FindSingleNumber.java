package Arrays;

public class FindSingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = nums[0];
        for (int i = 1; i < n; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
