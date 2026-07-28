class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        // Assume all rotations are valid initially
        boolean deg0 = true;
        boolean deg90 = true;
        boolean deg180 = true;
        boolean deg270 = true;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If a mismatch is found, that specific rotation becomes invalid
                if (mat[i][j] != target[i][j]) {
                    deg0 = false;
                }
                if (mat[i][j] != target[j][n - 1 - i]) {
                    deg90 = false;
                }
                if (mat[i][j] != target[n - 1 - i][n - 1 - j]) {
                    deg180 = false;
                }
                if (mat[i][j] != target[n - 1 - j][i]) {
                    deg270 = false;
                }
            }
        }
        
        // Return true if AT LEAST ONE rotation is still perfectly valid
        return deg0 || deg90 || deg180 || deg270;
    }
}