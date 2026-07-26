class Solution {
    public int countNegatives(int[][] grid) {

        int count = 0;
        int n = grid[0].length;

        for (int[] row : grid) {

            int l = 0;
            int r = n - 1;

            while (l <= r) {

                int mid = l + (r - l) / 2;

                if (row[mid] < 0) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            count += n - l;
        }

        return count;
    }
}