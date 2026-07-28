class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            
            // Add the secondary diagonal element, but only if it's not the exact same 
            // center element we just added to the primary diagonal (for odd sized matrices)
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }
        
        return sum;
    }
}