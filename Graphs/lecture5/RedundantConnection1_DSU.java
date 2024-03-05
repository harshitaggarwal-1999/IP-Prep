package Graphs.lecture5;

public class RedundantConnection1_DSU {
    int[] par;
    int[] rank;
    boolean ans;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        rank = new int[n + 1];
        ans = false;

        // intialize the parent array and rank array
        for (int[] edge : edges) {
            par[edge[0]] = edge[0];
            par[edge[1]] = edge[1];
            rank[edge[0]] = 1;
            rank[edge[1]] = 1;
        }

        // eaach element from the rank array will be iterated and if their leaders are different they are marked union but if they both have same parent that mean cycle has been formed and that eleemeent must be removed
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (ans == true) {
                return edge;
            }
        }
        return new int[0];
    }

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }

        int temp = find(par[x]);
        return par[x] = temp;
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
        } else {
            ans = true;
        }
    }
}