    // class Solution {
    //     public int maximumGap(int[] nums) {
    //         if(nums.length<2){
    //             return 0;

    //         }
    //         Arrays.sort(nums);
    //         int max=0;
    //         for(int i=1;i<nums.length;i++){
    //             int t=nums[i]-nums[i-1];
    //             max=Math.max(max,t);

    //         }
    //         return max;
    
    //     }
    // }

class Solution {
    public int maximumGap(int[] nums) {

        int n = nums.length;

        if (n < 2)
            return 0;

        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if (min == max)
            return 0;

        int gap = (max - min + n - 2) / (n - 1);

        int bucketCount = (max - min) / gap + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int x : nums) {

            int index = (x - min) / gap;

            bucketMin[index] = Math.min(bucketMin[index], x);
            bucketMax[index] = Math.max(bucketMax[index], x);
        }

        int ans = 0;
        int previous = min;

        for (int i = 0; i < bucketCount; i++) {

            if (bucketMin[i] == Integer.MAX_VALUE)
                continue;

            ans = Math.max(ans, bucketMin[i] - previous);

            previous = bucketMax[i];
        }

        return ans;
    }
}
    