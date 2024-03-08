package Graphs.Lecture7;

public class EulerianCircuit_DegreeMethod {
    // eulerpath means the path where each edge is travelled just once and all vtcs are travelled atleast once
    // in this if the degree of each node is even this means that cicuit is present here we all have the way where we can enter the vtx and exit it
    public int isPossible(int[][] paths) {
        // Code here
        int n = paths.length;
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paths[i][j] == 1) {
                    degree[i]++;
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 != 0) {
                ans = 0;
                break;
            }
        }
        return ans;
    }
}