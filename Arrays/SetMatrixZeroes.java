class Solution {
    public void setZeroes(int[][] matrix) {

        int n = matrix.length; // row length
        int m = matrix[0].length; // col length

        // to check if the -th row or 0th col is 0 or not
        boolean row = false;
        boolean col = false;

        // check if row 0th and col 0 th is zer if 0 then bool =  true; else it will remain false
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0) row = true;
        }
        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0) col = true;
        }

        // go for rest of matrix excluding 0th row and 0th col
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // now in place has been marked now just go over 0th col and if cell of ith row and 0th col is 0 that means that whole that row(i.e. col needs to be iterated) needs to be marked 0
        for(int i = 1; i < n; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // now in place has been marked now just go over 0th row and if any cell of 0th row and jth col is found 0 that means that whole col(i.e. row needs to be iterated) needs to be marked 0
        for(int j = 1; j < m; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < n; i++){
                    matrix[i][j] = 0;
                }
            }
        }


        // if boolean row is 0 the  whole mark 0th row = 0
        if(row){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
        // if boolean col is 0  then mark whole 0th col = 0
        if(col){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
    }
}