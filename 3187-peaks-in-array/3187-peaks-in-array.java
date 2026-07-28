import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] bit = new int[n + 1];
        
        // Step 1: Initialize the Fenwick Tree with initial peaks
        for (int i = 1; i < n - 1; i++) {
            if (isPeak(nums, i)) {
                update(bit, i + 1, 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        // Step 2: Process queries
        for (int[] q : queries) {
            if (q[0] == 1) {
                int l = q[1];
                int r = q[2];
                
                // If the subarray is too small to contain a peak, return 0
                if (l + 1 > r - 1) {
                    res.add(0);
                } else {
                    // Query range [l+1, r-1].
                    // In a 1-based BIT, this maps to range [l+2, r].
                    // We get this by taking prefixSum(r) - prefixSum(l + 1).
                    res.add(query(bit, r) - query(bit, l + 1));
                }
            } else {
                int idx = q[1];
                int val = q[2];
                
                // Remove the old peak contributions of idx-1, idx, and idx+1
                for (int i = idx - 1; i <= idx + 1; i++) {
                    if (isPeak(nums, i)) {
                        update(bit, i + 1, -1);
                    }
                }
                
                // Update the actual value in the array
                nums[idx] = val;
                
                // Re-evaluate and add new peak contributions for idx-1, idx, and idx+1
                for (int i = idx - 1; i <= idx + 1; i++) {
                    if (isPeak(nums, i)) {
                        update(bit, i + 1, 1);
                    }
                }
            }
        }
        
        return res;
    }
    
    // Helper Method: Checks if an index is safely a peak
    private boolean isPeak(int[] nums, int i) {
        if (i <= 0 || i >= nums.length - 1) {
            return false;
        }
        return nums[i - 1] < nums[i] && nums[i] > nums[i + 1];
    }
    
    // Fenwick Tree: Point Update
    private void update(int[] bit, int i, int delta) {
        while (i < bit.length) {
            bit[i] += delta;
            i += (i & -i); // Move to next node
        }
    }
    
    // Fenwick Tree: Prefix Sum Query
    private int query(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i); // Move to parent node
        }
        return sum;
    }
}