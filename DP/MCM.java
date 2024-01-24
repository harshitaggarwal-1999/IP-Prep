package DP;

public class MCM {

    public static void main(String[] args) {
        int[] arr = {4, 2 ,3, 5, 1};
        int ans = MCMRecursion(arr, 0, arr.length-1);
        System.out.println(ans);
    }

    public static int MCMRecursion(int[] arr,  int si, int ei){
        if(si+1 == ei){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = si+1; k <= ei-1; k++){
            int fp = MCMRecursion(arr, si, k);
            int sp = MCMRecursion(arr, k, ei);

            int sw = arr[si] * arr[k] * arr[ei];

            int total = fp + sp + sw;
            if(total < min){
                min = total;
            }
        }
        return min;
    }
}
