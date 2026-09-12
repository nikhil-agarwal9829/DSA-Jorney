// class Solution {
//     public int uniquePaths(int m, int n) {
//         long result = 1;
//         int totalMoves = m + n - 2;
//         int downMoves = Math.min(m - 1, n - 1); // Choose smaller for efficiency

//         for (int i = 1; i <= downMoves; i++) {
//             result = result * (totalMoves - downMoves + i) / i;
//         }
//         return (int) result;
//     }
// }
import java.util.*;

class Solution {

    public int ways(int m, int n, int dp[][]) {

        // Reached starting cell
        if (m == 0 && n == 0) {
            return 1;
        }

        // Outside the grid
        if (m < 0 || n < 0) {
            return 0;
        }

        // Already calculated
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // Come from above
        int l = ways(m - 1, n, dp);

        // Come from left
        int r = ways(m, n - 1, dp);

        dp[m][n] = l + r;

        return dp[m][n];
    }

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        // CHANGED: m,n -> m-1,n-1
        int re = ways(m - 1, n - 1, dp);

        return re;
    }
}