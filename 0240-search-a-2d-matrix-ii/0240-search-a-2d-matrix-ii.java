
class Solution {

    public boolean searchMatrix(int[][]grid , int target) {

        int m = grid.length;
        int n = grid[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if(grid[row][col]==target){
                return true;
            }

            if (grid[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}