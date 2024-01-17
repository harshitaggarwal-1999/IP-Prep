
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        // idea is whenever we find the same presum again that means that rest all elements between lastfound idx and curridx sum is 0 that's what we have implemented here
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int presum = 0; //  we will store values in presum
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            presum += arr[i];
            if(map.containsKey(presum) == false){ // if same presum is not available just update
                map.put(presum, i);
            }else{ // if that presum is available that means that  we just need to calculate the length and compete it with the maxans and we DONT have to UPDATE THE HASHMAP as we want the longest subarray with sum 0 not the smallest subarray
                int lastFoundIdx = map.get(presum);
                int len = i-lastFoundIdx;
                ans = Math.max(len, ans);
            }
        }
        return ans;
    }
}