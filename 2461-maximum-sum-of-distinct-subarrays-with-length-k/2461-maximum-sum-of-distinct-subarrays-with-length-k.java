class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long windowSum = 0;
        long ans = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            windowSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 > k) {

                windowSum -= nums[left];

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // Check valid window
            if (right - left + 1 == k && map.size() == k) {
                ans = Math.max(ans, windowSum);
            }
        }

        return ans;
    }
}