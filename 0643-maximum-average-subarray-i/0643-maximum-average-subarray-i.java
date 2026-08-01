class Solution {
    public double findMaxAverage(int[] nums, int k) {

        long sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        long maxSum = sum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}