class Solution {
    public int uniquePaths(int m, int n) {
        // Method 1 - brute force (recursion)

        // int ans = uniquepathsrec(0, 0, m, n);
        // return ans;

        // Method 2 - DP

        // int[][] dp =new int[m][n];
        // for(int[]  arr : dp){
        //     Arrays.fill(arr, -1);
        // }
        // int ans = uniquepathsdp(dp , 0, 0, m, n);
        // return ans;

        // Method 3 - combinometrics

        int N = m+n-2;
        int r = m-1;
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res*(N-r+i)/i;
        }

        return (int) res;
    }

    //   METHOD RECURSION
    public int uniquepathsrec(int currrow, int currcol, int m, int n){

        if(currrow == m-1 && currcol == n-1){
            return 1;
        }

        if(currrow >= m || currcol >= n){
            return 0;
        }

        int lans = uniquepathsrec(currrow, currcol+1, m, n);
        int rans = uniquepathsrec(currrow+1, currcol, m, n);

        return lans+rans;
    }


    // method dp
    public int uniquepathsdp(int[][] dp, int currrow, int currcol, int m, int n){

        if(currrow == m-1 && currcol == n-1){
            return 1;
        }

        if(currrow >= m || currcol >= n){
            return 0;
        }
        if(dp[currrow][currcol] != -1){
            return dp[currrow][currcol];
        }

        int lans = uniquepathsdp(dp, currrow, currcol+1, m, n);
        int rans = uniquepathsdp(dp, currrow+1, currcol, m, n);

        dp[currrow][currcol] = lans+rans;

        return lans+rans;
    }
}