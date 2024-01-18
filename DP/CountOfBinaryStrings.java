package DP;

import java.io.*;
import java.util.*;

public class CountOfBinaryStrings {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    long countStrings(int n) {

        // RECURSIVE APPROACH
         ArrayList<String> arr =  cshelper(n);
         return arr.size();

        // DP APPROACH
        long mod = 1000000007;
        long[] zeroes = new long[n+1]; // array of bits ending with zeroes
        long[] ones = new long[n+1]; // array of bits ending with ones

        //seed
        zeroes[0]= 0;
        ones[0] = 0;
        zeroes[1] = 1; // no of strings ending with zeroes with length 1 is 1
        ones[1] = 1; // no of strings ending with ones with length 1 is 1


        for(int i = 2 ;i <= n; i++){
            zeroes[i] = (zeroes[i-1]+ones[i-1])%mod; // as zero can be added to all the elements ending with zero and all the element ending with one in last
            // mod because may be at some time both add both exceeds the val so mod is necessary
            ones[i] = zeroes[i-1]; // as 1 can be added with the all the elements ending with just 0 in the last
            // System.out.println(" i = "+i+" , " +zeroes[i] +" , "+ ones[i]);
        }


        long zeroesans = zeroes[n];
        long onesans = ones[n];

        return (long)((zeroesans+onesans)%mod);// may be in last zeroes1 is big and onesans is big and both when added becomes big so they need mod

    }

    ArrayList<String> cshelper(int n){
        if(n == 1){
            ArrayList<String> baseArr = new ArrayList<>();
            baseArr.add("0");
            baseArr.add("1");
            return baseArr;
        }

        ArrayList<String> tempans = cshelper(n-1);
        ArrayList<String> mainans = new ArrayList<>();

        for(int i = 0; i < tempans.size(); i++){
            String currstring = tempans.get(i);

            if(currstring.charAt(0) != '1'){
                mainans.add("1"+currstring);
            }
            mainans.add("0"+currstring);
        }
        return mainans;

    }
}