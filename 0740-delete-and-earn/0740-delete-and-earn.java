class Solution {

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] earn = new int[max + 1];

        for (int num : nums) {
            earn[num] += num;
        }

        int[] dp = new int[max + 1];

        dp[0] = earn[0];

        if (max >= 1) {
            dp[1] = Math.max(earn[0], earn[1]);
        }

        for (int i = 2; i <= max; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    earn[i] + dp[i - 2]
            );
        }

        return dp[max];
    }
}