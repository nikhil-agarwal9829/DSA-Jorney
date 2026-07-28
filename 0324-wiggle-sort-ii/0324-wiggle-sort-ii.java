class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int median = findKth(nums, (n + 1) / 2);

        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } 
            else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } 
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Quick Select
    private int findKth(int[] nums, int k) {

        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k;

        while (left <= right) {

            int pivot = partition(nums, left, right);

            if (pivot == k)
                return nums[pivot];

            if (pivot < k)
                left = pivot + 1;
            else
                right = pivot - 1;
        }

        return -1;
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, p, i);
                p++;
            }
        }

        swap(nums, p, right);
        return p;
    }
}