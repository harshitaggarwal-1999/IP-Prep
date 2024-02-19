package Graphs.lecture1;
import java.util.*;
public class RottenOranges  {
    public class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
            }
        }
        if(fresh == 0) return 0;

        int[][] dirs = {{-1, 0}, {0,1}, {1,0}, {0,-1}};
        int level = -1;
        while(q.size() > 0){
            level++;
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove();

                for(int i = 0; i < dirs.length; i++){
                    int rowdash = rem.row + dirs[i][0];
                    int coldash = rem.col + dirs[i][1];

                    if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || grid[rowdash][coldash] != 1){
                        continue;
                    }
                    // it will work only if the current element which is getting pushed is "fresh"
                    fresh--;
                    q.add(new Pair(rowdash, coldash));
                    grid[rowdash][coldash] = 2;
                }
            }
        }
        if(fresh == 0){
            return level;
        }else {
            return -1;
        }
    }
}