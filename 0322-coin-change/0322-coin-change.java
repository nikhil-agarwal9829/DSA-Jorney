class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;

        int dp[][] = new int[n][amount + 1];

        // First coin
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = t / coins[0];
            else
                dp[0][t] = amount + 1;
        }

        // Remaining coins
        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= amount; j++) {

                // Don't take coin
                int not = dp[i - 1][j];

                // Take coin
                int take = amount + 1;

                if (coins[i] <= j) {
                    take = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(not, take);
            }
        }

        if (dp[n - 1][amount] == amount + 1)
            return -1;

        return dp[n - 1][amount];
    }
}