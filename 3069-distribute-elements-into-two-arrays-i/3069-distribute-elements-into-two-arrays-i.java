class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int j = 0; 
        int k = 1; 

        for (int i = 2; i < n; i++) {

            if (nums[j] > nums[k]) {

                int temp = nums[i];
                for (int p = i; p > j + 1; p--) {
                    nums[p] = nums[p - 1];
                }
                nums[j + 1] = temp;

                j++;
                k = i;

            } else {

                k = i;
            }
        }

        return nums;
    }
}