import java.util.*;

class pair implements Comparable<pair>{
    int num;
    int freq;

    pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
    //   @Override
    public int compareTo(pair o){
        return this.freq - o.freq;
    }
}
class Solution {

    public static int[] topKFrequent(int[] nums, int k) {

        // hashmap update and the key-values
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // iterate over all values in hashmap and add it to the priorityQueue of pair(num, freq) and add comparator of sorting on freq
        PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : map.keySet()) {
            int freq = map.get(num);

            pq.add(new pair(num, freq));
        }

        // priority of reverseorder(giving largest first)
        int[] ans = new int[k];
        int i = 0;
        while (k-- > 0) {
            pair p = pq.remove();
            ans[i++] = p.num;
        }
        return ans;
    }
}