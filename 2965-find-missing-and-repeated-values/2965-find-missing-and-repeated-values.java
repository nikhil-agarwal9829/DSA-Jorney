class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int N = n * n;

        // Step 1: XOR all numbers in grid and from 1 to N
        int xor = 0;

        for (int[] row : grid) {
            for (int num : row) {
                xor ^= num;
            }
        }

        for (int i = 1; i <= N; i++) {
            xor ^= i;
        }

        // xor = repeated ^ missing

        // Step 2: Find the rightmost set bit
        int mask = xor & (-xor);

        int x = 0;
        int y = 0;

        // Step 3: Divide grid numbers into two groups
        for (int[] row : grid) {
            for (int num : row) {
                if ((num & mask) != 0)
                    x ^= num;
                else
                    y ^= num;
            }
        }

        // Step 4: Divide numbers 1..N into the same two groups
        for (int i = 1; i <= N; i++) {
            if ((i & mask) != 0)
                x ^= i;
            else
                y ^= i;
        }

        // Now x and y are the repeated and missing numbers
        // We don't know which is which

        int count = 0;

        for (int[] row : grid) {
            for (int num : row) {
                if (num == x)
                    count++;
            }
        }

        if (count == 2)
            return new int[]{x, y};

        return new int[]{y, x};
    }
}