class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        // move non-zeros
        for (int num : nums) {
            if (num != 0) nums[j++] = num;
        }

        // fill zeros
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}