public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> arr) {
        int n = arr.size();

        // step 1 do the xor with whole array and 1 to n
        int xr = 0;
        for(int i = 0; i < n; i++){
            xr = xr ^ arr.get(i);
            xr = xr ^ (i+1);
        }

        // step 2 find the first 1 bit from right
        int bitNo = 0;
        while(true){
            if((xr & (1<<bitNo)) != 0){
                break;
            }
            bitNo++;
        }

        //  step 3 seperate it into two basket one and zero compliment
        int zero = 0;
        int one = 0;
        // step 3a. iterating over array elements and doing th check if arr.get(i) & (1<<bitNo) != 0
        for(int i = 0; i < n; i++){
            if((arr.get(i) & (1<<bitNo)) != 0){
                one = one ^ arr.get(i);
            }else{
                zero = zero ^ arr.get(i);
            }
        }

        //step 3b.  iterating over array elements and doing the check if (i+1) & (1<<bitNo) != 0
        for(int i = 1; i <= n; i++){
            if(((i) & (1<<bitNo)) != 0){
                one = one ^ (i);
            }else{
                zero = zero ^ (i);
            }
        } // this will just segregate both missing number and repeating number

        // step 4 verify
        int count = 0;
        ArrayList<Integer> ansarr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(one == arr.get(i)) count++;
        }
        if(count == 2){
            ansarr.add(one);
            ansarr.add(zero);
        }else{
            ansarr.add(zero);
            ansarr.add(one);
        }
        return ansarr;
    }
}
