package Graphs.lecture6;

import java.util.Arrays;

public class RedundantConeections2 {
    int[] parent;
    int[] rank;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        Arrays.fill(indegree, -1);
        int bl1 = -1;
        int bl2 = -1;

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            if (indegree[v] == -1) {
                // pehle se indegree me kuch nahi tha to just directly put kardo kiske vajah se indegree badi hai
                indegree[v] = i; // i denotes kausi edge ki vajah se badi haI indegree
            } else {
                // iska matlab hai indegree == 2 vala case hai to just directly bl1 k0o jo nay add hu ahi usme put kardo and jo pehle vaale ki vajah se indegree bada tha usey bl2 me daaldo
                bl1 = i;
                bl2 = indegree[v];
            }
        }

        parent = new int[n + 1];
        rank = new int[n + 1];

        // initialise the parent array
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // iterate over the edges
        for (int i = 0; i < n + 1; i++) {
            if (bl1 == i) continue;
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            boolean flag = union(u, v);
            if (flag == true) { //  cycle or closed figure exists
                if (bl1 == -1) {
                    // no edge is blacklisted this means that case is when indegree iof all edges is 1 and cycle is found
                    return edge;
                } else {
                    return edges[bl2];
                }
            }
        }
        return edges[bl1];
    }

    public int find(int x) {
        if (parent[x] == x) return x;

        int temp = find(parent[x]);

        return parent[x] = temp;
    }

    public boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx == ly) { //  closed figuure or cycle found
            return true;
        } else {
            if (rank[x] > rank[y]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;

            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
        }
        return false;
    }
}