class Solution {

    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    int solve(int l, int r) {

        if (l == r)
            return 0;

        if (dp[l][r] != 0)
            return dp[l][r];

        int best = 0;

        for (int mid = l; mid < r; mid++) {

            int leftSum = prefix[mid + 1] - prefix[l];

            int rightSum = prefix[r + 1] - prefix[mid + 1];

            if (leftSum < rightSum) {

                best = Math.max(
                    best,
                    leftSum + solve(l, mid)
                );

            } else if (leftSum > rightSum) {

                best = Math.max(
                    best,
                    rightSum + solve(mid + 1, r)
                );

            } else {

                best = Math.max(
                    best,
                    leftSum + Math.max(
                        solve(l, mid),
                        solve(mid + 1, r)
                    )
                );
            }
        }

        return dp[l][r] = best;
    }
}