package Graphs;

import java.util.*;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // disconnected graph so all sources shall be individually checked
        for (int i = 0; i < n; i++) {
            int[] vis = new int[n];

            Arrays.fill(vis, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(i);
            vis[i] = 10;

            while (q.size() > 0) {
                int rem = q.remove();
                int[] nbrs = graph[rem];

                for (int nbr : nbrs) {
                    if (vis[nbr] == -1) { // unvisited
                        //add to queue
                        q.add(nbr);
                        if (vis[rem] == 10) {
                            vis[nbr] = 12;
                        } else {
                            vis[nbr] = 10;
                        }
                    } else { // visited
                        if (vis[nbr] == vis[rem]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}