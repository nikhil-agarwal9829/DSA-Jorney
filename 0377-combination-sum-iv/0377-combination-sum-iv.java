class Solution {

    int[] dp;

    public int combinationSum4(int[] nums, int target) {

        dp = new int[target + 1];

        Arrays.fill(dp, -1);

        return solve(nums, target);
    }

    int solve(int[] nums, int target){

        if(target == 0)
            return 1;

        if(target < 0)
            return 0;

        if(dp[target] != -1)
            return dp[target];

        int ways = 0;

        for(int num : nums){
            ways += solve(nums, target - num);
        }

        dp[target] = ways;

        return dp[target];
    }
}

// class Solution {

//     public int combinationSum4(int[] nums, int target) {

//         int[] dp = new int[target + 1];

//         dp[0] = 1;

//         for(int i = 1; i <= target; i++) {

//             for(int num : nums) {

//                 if(i >= num) {
//                     dp[i] += dp[i - num];
//                 }
//             }
//         }

//         return dp[target];
//     }
// }