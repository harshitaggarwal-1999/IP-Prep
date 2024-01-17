class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length; // n*n matrix so matrix.length == matrix[0].length

        // transpose 
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reflect
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
// 1 4 7 | 7 4 1
// 2 5 8 | 8 5 2
// 3 6 9 | 9 6 3 