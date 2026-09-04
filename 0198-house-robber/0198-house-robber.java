class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int p1=nums[0];
        int p2=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int t=Math.max(p2,(p1+nums[i]));
            p1=p2;
            p2=t;

        }
        return Math.max(p2,p1);
    }
}