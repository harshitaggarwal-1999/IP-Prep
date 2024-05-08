package Arrays.Arrays7;
import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            int[][] currans = new int[1][2];
            currans[0] = newInterval;
            return currans;
        }
        // all unoverlapped intervals will be add in first half
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        int[] arr = new int[2];
        arr[0] = Integer.MAX_VALUE;
        arr[1] = Integer.MIN_VALUE;
        boolean flag = false;

        System.out.println(i);
        // now comes the overlapping part
        while (i < n && intervals[i][0] <= newInterval[1]) {
            flag = true;
            int[] currinterval = intervals[i];

            arr[0] = Math.min(Math.min(currinterval[0], newInterval[0]), arr[0]);
            arr[1] = Math.max(Math.max(currinterval[1], newInterval[1]), arr[1]);

            i++;

        }
        if (flag == false) {
            ans.add(newInterval);
        } else {
            ans.add(arr);
        }
        // comes the last part left after overlapping if any
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}