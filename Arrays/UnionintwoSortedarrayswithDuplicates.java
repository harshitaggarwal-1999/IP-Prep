package Arrays;

import java.util.*;

public class UnionintwoSortedarrayswithDuplicates {

    public static int nextDistinct(int[] arr, int x) {
        while (x < arr.length - 1 && arr[x] == arr[x + 1]) {
            x++;
        }
        return x + 1;
    }

    public static List<Integer> sortedArray(int[] a, int[] b) {
        // Write your code here
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                ans.add(a[i]);
                i = nextDistinct(a, i);
            } else if (a[i] > b[j]) {
                ans.add(b[j]);
                j = nextDistinct(b, j);
            } else {
                ans.add(a[i]);
                i = nextDistinct(a, i);
                j = nextDistinct(b, j);
            }
        }
        while (i < n) {
            ans.add(a[i]);
            i = nextDistinct(a, i);
        }
        while (j < m) {
            ans.add(b[j]);
            j = nextDistinct(b, j);
        }


        return ans;
    }
}