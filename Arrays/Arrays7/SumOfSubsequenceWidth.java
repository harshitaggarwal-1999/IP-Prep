package Arrays.Arrays7;

import java.util.*;

public class SumOfSubsequenceWidth {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        long mod = 1000000007L;
        long[] pow = new long[n];
        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (2 * pow[i - 1]) % mod;
        }

        for (int i = 0; i < n; i++) {
            ans = (ans + nums[i] * pow[i] - nums[i] * pow[n - i - 1]) % mod;

        }

        return (int) Math.abs(ans);
    }
}
