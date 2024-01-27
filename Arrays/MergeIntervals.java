package Arrays;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        // sort array according to starting point in increasing order
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        ArrayList<int[]> list = new ArrayList<>();

        for(int[] interval: intervals){
            // if list is empty then just push the curr interval
            if(list.size() == 0){
                list.add(interval);
            }else{
                // now here the list is not empty now get the prev interval an dcompare if the overlapping is happening or not if yes then just update the previntervals endpoint as Math.max(previnterval.endpoint, currInterval.endpoint)
                int[] prevInterval = list.get(list.size()-1);
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }else{
                    // if not overlapping then just push the interval in the list.
                    list.add(interval);
                }
            }
        }
        /// convert the list to the 2-d array given initially and size of that 2-d array will be equal to list.size() and return 
        return list.toArray(new int[list.size()][]);


    }
}