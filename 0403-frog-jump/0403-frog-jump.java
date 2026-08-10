import java.util.*;

class Solution {

    public boolean canCross(int[] stones) {

        int n = stones.length;

        if (n == 1)
            return true;

        // First jump must be exactly 1
        if (stones[1] != 1)
            return false;

        // [0, 1] -> first jump reaches the destination
        if (n == 2)
            return true;

        boolean[][] dp = new boolean[n][n + 1];

        dp[1][1] = true;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        for (int i = 1; i < n; i++) {

            for (int jump = 1; jump <= n; jump++) {

                if (!dp[i][jump])
                    continue;

                for (int nextJump = jump - 1;
                     nextJump <= jump + 1;
                     nextJump++) {

                    if (nextJump <= 0)
                        continue;

                    int nextPosition = stones[i] + nextJump;

                    if (map.containsKey(nextPosition)) {

                        int nextIndex = map.get(nextPosition);

                        if (nextIndex == n - 1)
                            return true;

                        dp[nextIndex][nextJump] = true;
                    }
                }
            }
        }

        return false;
    }
}