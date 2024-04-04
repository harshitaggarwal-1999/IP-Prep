package Graphs.Lecture8;

import java.util.ArrayDeque;

public class MaximumBarpartiteGraph_MaximumFlow_FOrdFulkerson {
    public int maximumMatch(int[][] eg) {
        // Code here
        int size = eg.length + eg[0].length + 2;
        // no. of persons
        int m = eg.length;
        // no of jobs
        int n = eg[0].length;

        int[][] g = new int[size][size];

        // create a graph
        // connect source to persons
        for (int i = 1; i <= m; i++) {
            g[0][i] += 1;
            g[i][0] += 1;
        }

        // connect jobs to sink
        for (int i = m + 1; i < m + n + 1; i++) {
            g[size - 1][i] += 1;
            g[i][size - 1] += 1;
        }

        // connect persons to jobs
        int p1 = 1;
        int pm = m;
        int j1 = m + 1;
        int jn = m + n;
        for (int i = 0; i < eg.length; i++) {
            for (int j = 0; j < eg[0].length; j++) {
                g[i + p1][j + j1] += eg[i][j];
                g[j + j1][i + p1] += eg[i][j];
            }
        }

        // apply ford fulkerson and edward karp
        int[] parent = new int[size];
        int src = 0;
        int sink = size - 1;
        int ans = 0;

        while (bfs(g, 0, size - 1, parent) == true) {

            int min = Integer.MAX_VALUE;
            for (int i = sink; i != src; i = parent[i]) {
                int u = parent[i];
                int v = i;

                min = Math.min(min, g[u][v]);
            }
            ans += min;
            for (int i = sink; i != src; i = parent[i]) {
                int u = parent[i];
                int v = i;

                g[u][v] -= min;
                g[v][u] += min;
            }
        }
        return ans;
    }

    public boolean bfs(int[][] graph, int src, int sink, int[] path) {
        boolean[] vis = new boolean[path.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;
        while (q.size() > 0) {
            int rem = q.remove();

            for (int i = 0; i < graph[0].length; i++) {
                if (vis[i] == false && graph[rem][i] != 0) {
                    q.add(i);
                    vis[i] = true;

                    // jiski vajah se nikla hu usey apne vaale ke path me daal dene ka hai
                    path[i] = rem;
                }
            }
        }
        return vis[sink];
    }
}