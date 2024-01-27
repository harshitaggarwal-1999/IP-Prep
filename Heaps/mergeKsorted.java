import java.util.* ;
import java.io.*;
import java.util.ArrayList;

class pair implements Comparable<pair>{
    int val; // val
    int ap; // array position
    int vp; // value position

    pair(int val, int ap, int vp){
        this.val = val;
        this.ap = ap;
        this.vp = vp;
    }

    @Override
    public int compareTo(pair o){
        return this.val - o.val;
    }
}

public class Solution
{

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        // Write your code here.
        PriorityQueue<pair> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // adding first elemts of all arrays into the list
        for(int i = 0; i < k; i++){
            pq.add(new pair(kArrays.get(i).get(0), i, 0)); // val, aarray position, value position
        }

        while(pq.size() > 0){
            pair currpair = pq.remove(); // remove the pair from the priority queue which has smallest val and add it to our answer arraylist

            int ap = currpair.ap;
            int vp = currpair.vp;

            ans.add(currpair.val);

            if(vp+1 < kArrays.get(ap).size()){
                pq.add(new pair(kArrays.get(ap).get(vp+1), ap, vp+1));
            }
        }
        return ans;

    }
}
