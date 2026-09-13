import java.util.*;

class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int total = 0;
        for (int x : nums)
            total += x;

        List<Integer>[] left = new ArrayList[half + 1];
        List<Integer>[] right = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        // Generate all sums
        generate(nums, 0, half, 0, 0, left);
        generate(nums, half, n, 0, 0, right);

        for (int i = 0; i <= half; i++)
            Collections.sort(right[i]);

        int ans = Integer.MAX_VALUE;

        // Take i elements from left
        for (int i = 0; i <= half; i++) {

            // Take half-i elements from right
            List<Integer> list = right[half - i];

            for (int x : left[i]) {

                int target = total / 2 - x;

                int pos = Collections.binarySearch(list, target);

                if (pos < 0)
                    pos = -pos - 1;

                if (pos < list.size()) {
                    int sum = x + list.get(pos);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (pos > 0) {
                    int sum = x + list.get(pos - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    // TAKE / SKIP
    void generate(int[] nums, int i, int end,
                  int count, int sum,
                  List<Integer>[] result) {

        if (i == end) {
            result[count].add(sum);
            return;
        }

        // Skip
        generate(nums, i + 1, end, count, sum, result);

        // Take
        generate(nums, i + 1, end,
                 count + 1, sum + nums[i], result);
    }
}