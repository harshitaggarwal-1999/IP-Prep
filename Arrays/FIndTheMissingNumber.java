package Arrays;

import java.util.*;

public class FIndTheMissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            ans[nums[i]] = nums[i];
        }

        for (int i = 0; i < n + 1; i++) {
            if (ans[i] == -1) {
                return i;
            }
        }
        return -1;
    }
}