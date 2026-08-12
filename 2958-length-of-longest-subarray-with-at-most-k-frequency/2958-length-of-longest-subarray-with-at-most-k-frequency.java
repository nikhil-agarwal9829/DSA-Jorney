class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int ans = 0;

        for (int j = 0; j < nums.length; j++) {

            // Add nums[j] to current window
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // If nums[j] occurs more than k times,
            // shrink from the left
            while (map.get(nums[j]) > k) {

                map.put(nums[i], map.get(nums[i]) - 1);

                i++;
            }

            // Current window [i...j] is valid
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}