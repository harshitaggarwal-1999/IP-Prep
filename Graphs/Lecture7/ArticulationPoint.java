package Graphs.Lecture7;

import java.util.ArrayList;

public class ArticulationPoint {
    static int[] par;
    static int[] disc;
    static int[] low;
    static boolean[] vis;
    static boolean[] ap;
    static int count;
    static int time;

    public static int doctorStrange(int n, int k, int g[][]) {
        //Complete the function
        // make the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < g.length; i++) {
            int u = g[i][0];
            int v = g[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        low = new int[k + 1];
        disc = new int[k + 1];
        par = new int[k + 1];
        vis = new boolean[k + 1];
        ap = new boolean[k + 1];
        count = 0;
        time = 0;

        articulationPoint(1, graph);

        int ans = 0;
        for (int i = 0; i < ap.length; i++) {
            if (ap[i] == true) {
                ans++;
            }
        }
        return ans;
    }

    public static void articulationPoint(int u, ArrayList<ArrayList<Integer>> graph) {
        disc[u] = low[u] = time;
        time++;
        vis[u] = true;

        ArrayList<Integer> nbrs = graph.get(u);
        for (int v : nbrs) {
            // parent
            if (par[u] == v) {
                continue;
            } else if (vis[v] == true) { // non parent
                low[u] = Math.min(low[u], disc[v]);
            } else {
                par[v] = u;
                articulationPoint(v, graph);
                if (par[u] == 0) {
                    count++;
                    if (count >= 2) {
                        ap[u] = true;
                    }
                } else {
                    if (low[v] >= disc[u]) {
                        ap[u] = true;
                    }
                    low[u] = Math.min(low[u], low[v]);

                }
            }
        }
    }
}