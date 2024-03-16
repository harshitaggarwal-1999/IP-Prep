package Graphs.Lecture8;
import java.util.*;
public class MaximumFlowFordFulkerson {
    int findMaxFlow(int N, int M, ArrayList<ArrayList<Integer>> edges) {
        // code here
        // make the graph of adjacency matrix
        int[][] graph = new int[N][N];

        // iterate over edges to make the graph
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> edge = edges.get(i);
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int wt = edge.get(2);

            graph[u][v] += wt;
            graph[v][u] += wt;
        }

        int[] parent = new int[N];
        int src = 0;
        int sink = N - 1;
        int ans = 0;

        while (bfs(graph, 0, N - 1, parent) == true) {

            int min = Integer.MAX_VALUE;
            for (int i = sink; i != src; i = parent[i]) {
                int u = parent[i];
                int v = i;

                min = Math.min(min, graph[u][v]);
            }
            ans += min;
            for (int i = sink; i != src; i = parent[i]) {
                int u = parent[i];
                int v = i;

                graph[u][v] -= min;
                graph[v][u] += min;
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