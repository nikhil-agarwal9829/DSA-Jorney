class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // The dimensions of the new matrix are swapped (m x n instead of n x m)
        int[][] result = new int[m][n];
        
        // Loop through the original matrix and place elements in their flipped coordinates
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
}