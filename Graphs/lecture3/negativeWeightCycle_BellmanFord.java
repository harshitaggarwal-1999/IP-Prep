package Graphs.lecture3;

public class negativeWeightCycle_BellmanFord {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        //code here
        int[] ans = new int[edges.length];
        ans[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (ans[u] + wt < ans[v]) {
                    ans[v] = ans[u] + wt;
                }
            }
        }
        boolean updated = false;
        for (int i = 0; i < 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (ans[u] + wt < ans[v]) {
                    ans[v] = ans[u] + wt;
                    updated = true;
                    break;
                }
            }
        }

        return (updated) ? 0 : 1;
    }
}
