package Graphs.lecture1;

import java.util.*;

public class NumberOfDistinctIslands {
    StringBuilder sb;

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sb = new StringBuilder();
                    sb.append("X");
                    traversal(grid, i, j);
                    if (set.contains(sb.toString()) == false) {
                        set.add(sb.toString());
                    }
                }
            }
        }
        return set.size();
    }

    public void traversal(int[][] grid, int i, int j) {

        grid[i][j] = 0;

        // up check
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            sb.append("U");
            traversal(grid, i - 1, j);
        }

        // right check
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            sb.append("R");
            traversal(grid, i, j + 1);
        }

        // down check
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            sb.append("D");
            traversal(grid, i + 1, j);
        }

        // left check
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            sb.append("L");
            traversal(grid, i, j - 1);
        }

        sb.append("Z");

    }
}
