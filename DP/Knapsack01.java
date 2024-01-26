package DP;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] price = {1, 4, 5, 7};

//        int ans = KnapsackRec(wt, price, 7, 0);
        int cap = 7;
//        int ans = KnapsackTD(wt, price, cap, 0, new int[wt.length][cap + 1]);// cap+1 because we want to consider cap as a number also in dp that's why we will be taking cap+1 dp array
        int ans = KnapsackBU(wt, price, cap);
        System.out.println(ans);
    }

    public static int KnapsackRec(int[] wt, int[] price, int cap, int vidx) {
        if (vidx == wt.length || cap == 0) {
            return 0;
        }

        // exclude
        int e = KnapsackRec(wt, price, cap, vidx + 1);

        // include
        int i = 0;
        if (cap >= wt[vidx]) {
            i = KnapsackRec(wt, price, cap - wt[vidx], vidx + 1) + price[vidx];
        }
        int ans = Math.max(e, i);

        return ans;
    }

    public static int KnapsackTD(int[] wt, int[] prices, int cap, int vidx, int[][] dp) {

        if (vidx == wt.length || cap == 0) { //  agar capacity == 0 to matab base case hit ab aur kuch nahi jaega to return 0 ::: agar vidx == wt.length yni ki ab wt ya price vale array me kuch nahi bacha toh return kardo kyuki consider karne nke liye kuc bacha hi nahi
            return 0;
        }
        if (dp[vidx][cap] != 0) {
            return dp[vidx][cap];
        }
        // exclude
        int e = KnapsackTD(wt, prices, cap, vidx + 1, dp); // vidx badega sirf because humne jo element hum consider kar rhe hai usey apne dpo me add nahi karenge that's why
        // include
        int i = 0;
        if (cap >= wt[vidx]) // imagine if the next wt which is going to be considered is greater than capacity available so that's why need to check
            i = KnapsackTD(wt, prices, cap - wt[vidx], vidx + 1, dp) + prices[vidx];

        int ans = Math.max(e, i);
        dp[vidx][cap] = ans;
        return ans;

    }

    public static int KnapsackBU(int[] wt, int[] prices, int cap) {
        int n = wt.length;
        // dp array
        int[][] dp = new int[n + 1][cap + 1];
        // row - cap
        // col - vidx

        // row nth - means all wts has been considered and base case vidx == wtlength has been hit then we have to return 0
        // col 0th - means cap of bag is now 0 even if we have values or not that more weights cannot be added in the bag

        // direction set
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 1; col <= cap; col++) {

                // exclude
                int e = dp[row + 1][col];

                // include
                int i = 0;
                if (col >= wt[row]) {
                    i = (dp[row + 1][col - wt[row]]) + prices[row];
                }

                int max = Math.max(e, i);


                dp[row][col] = max;
//                print2D(dp);
            }
        }

        return dp[0][cap];
    }
    public static void print2D(int mat[][])
    {
        System.out.println(Arrays.deepToString(mat));
    }


}
