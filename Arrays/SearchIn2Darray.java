class Solution {
    public boolean searchMatrix(int[][] matrix, int x) {
        // we will use mod of binary search in this case

        // we will stand in the top right corner of the matrix and then from there we will check if x(number needs to be found) is smaller than arr[i][j] (decrease j) just go left other wise go downwards(increase i)

        int i = 0;
        int j = matrix[0].length-1;

        while(i < matrix.length && j >= 0){ // this because i always --  hi hoga and j ++ hi hoga to koi condition nahi hai jaha aur ye fail hoga
            if(x == matrix[i][j]) { // milgya to just return true
                return true;

            } else if(x > matrix[i][j]) { // target bada hai to just go downward
                i++;

            } else { // target chota hai to just go to the left
                j--;
            }
        }
        return false; // ab bhai vo mila hi nahi to return false;

    }
}