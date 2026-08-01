// class Solution {
//     boolean solve(int i,int target,int[] nums){

//         if(target==0)
//             return true;

//         if(i==nums.length)
//             return false;

//         boolean take=false;

//         if(nums[i]<=target)
//             take=solve(i+1,target-nums[i],nums);

//         boolean skip=solve(i+1,target,nums);

//     return take||skip;
// }
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];
//         }
//         if(sum%2!=0){
//             return false;
//         }
//         int target=sum/2;

//         return solve(0,target,nums);
        
        
//     }
// }


class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        dp = new Boolean[nums.length + 1][target + 1];

        return solve(nums, 0, target);
    }

    boolean solve(int[] nums, int i, int target) {

        if (target == 0)
            return true;

        if (i == nums.length)
            return false;

        if (dp[i][target] != null)
            return dp[i][target];

        boolean take = false;

        if (nums[i] <= target)
            take = solve(nums, i + 1, target - nums[i]);

        boolean skip = solve(nums, i + 1, target);

        dp[i][target] = take || skip;

        return dp[i][target];
    }
}