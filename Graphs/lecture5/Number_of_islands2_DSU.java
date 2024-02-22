package Graphs.lecture5;

import java.util.*;

public class Number_of_islands2_DSU {
    static int ans;
    static int[] par;
    static int[] rank;

    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.
        par = new int[n * m];
        rank = new int[n * m];
        ans = 0;
        Arrays.fill(par, -1);
        ArrayList<Integer> mainans = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < q.length; i++) {
            int row = q[i][0];
            int col = q[i][1];

            int cellnumber = (row * m) + col;
            par[cellnumber] = cellnumber;
            rank[cellnumber] = 1;
            ans++;

            for (int idx = 0; idx < dirs.length; idx++) {
                int rowdash = row + dirs[idx][0];
                int coldash = col + dirs[idx][1];

                int celldash = (rowdash * m) + coldash;

                // isme par[celldash] == -1 ka matlab hai ki originally in graph vaha par water nahi hoga
                if (rowdash < 0 || coldash < 0 || rowdash >= n || coldash >= m || par[celldash] == -1) {
                    continue;
                }
                union(celldash, cellnumber);
            }
            mainans.add(ans);
        }

        int[] ansarr = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            ansarr[i] = mainans.get(i);
        }
        return ansarr;
    }

    public static int find(int x) {
        // base case
        if (par[x] == x) {
            return x;
        }
        // recursion calls
        int temp = find(par[x]);
        // return ans
        return par[x] = temp;
    }

    public static void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            // agar union hua hai to matlab pkka se do islands ki grouping hui hogi jo pehle alag alag the  issiliye answer ko ek se ghataenge i.e. islands count ko ek se ghataenge
            ans--;
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
        }
    }
}
