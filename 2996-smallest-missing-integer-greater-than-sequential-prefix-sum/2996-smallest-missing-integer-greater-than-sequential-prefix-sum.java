class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int idx=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
                idx++;
            }else{
                break;
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(idx<=nums.length+1){
            if(!set.contains(sum)){
                return sum;

            }
            sum++;
            idx++;
        }
        return sum;

    }
}