class Solution {
    public int findMin(int[] nums) {
        // if(nums.length==1)return nums[0];
        // if(nums.length==2){
        //     if(nums[0]>nums[1]){
        //         return nums[1];
        //     }else{ 
        //     return nums[0];
        //     }
        // }
        int l=0;
        int r=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int mid=(l+(r-l)/2);
            min=Math.min(min,nums[mid]);
            if(nums[mid]>=nums[r]){
                l=mid+1;
            }
            if(nums[mid]<nums[r]){
                r=mid-1;
            }

        }
        return min;
        
    }
}