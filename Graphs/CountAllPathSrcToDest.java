package Graphs;

import java.util.ArrayList;

public class CountAllPathSrcToDest {
    // Function to count paths between two vertices in a directed graph.
    int ans;

    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                          int destination) {
        // Code here
        ans = 0;
        traversal(source, destination, adj);
        return ans;
    }

    public void traversal(int source, int dest, ArrayList<ArrayList<Integer>> adj) {
        if (source == dest) {
            ans++;
            return;
        }
        ArrayList<Integer> nbrs = adj.get(source);
        for (Integer nbr : nbrs) {
            traversal(nbr, dest, adj);
        }
    }
}