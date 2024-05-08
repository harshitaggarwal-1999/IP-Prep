package Arrays.Arrays7;

import java.util.*;
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<Integer> si = new ArrayList<>();
        ArrayList<Integer> ei = new ArrayList<>();

        for (int[] arr : intervals) {
            si.add(arr[0]);
            ei.add(arr[1]);
        }

        Collections.sort(si);
        Collections.sort(ei);

        int i = 0, j = 0;
        int n = intervals.length;
        if (n == 1 || n == 0)
            return intervals;
        ArrayList<int[]> ans = new ArrayList<>();

        while (i + 1 < n && j < n) {
            if (si.get(i + 1) <= ei.get(i)) {
                i++;
            } else {
                int[] arr = new int[2];
                arr[0] = si.get(j);
                arr[1] = ei.get(i);
                ans.add(arr);
                j = i + 1;
                i++;
            }
        }
        if (j != n) {
            int[] arr = new int[2];
            arr[0] = si.get(j);
            arr[1] = ei.get(i);
            ans.add(arr);
        }
        // int[][] mainans = new int[ans.size()][2];
        // for (i = 0; i < ans.size(); i++) {
        //     mainans[i] = ans.get(i);
        // }
        // return mainans;

        return ans.toArray(new int[ans.size()][2]);
    }
}