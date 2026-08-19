class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Maximum possible = 2 families per row
        int ans = 2 * n;

        HashMap<Integer, boolean[]> map = new HashMap<>();

        // Store reserved seats for each affected row
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            if (!map.containsKey(row)) {
                map.put(row, new boolean[11]);
            }

            map.get(row)[col] = true;
        }

        // Only rows having reserved seats need checking
        for (boolean[] seats : map.values()) {

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // 2,3,4,5
            for (int j = 2; j <= 5; j++) {
                if (seats[j]) {
                    left = false;
                    break;
                }
            }

            // 4,5,6,7
            for (int j = 4; j <= 7; j++) {
                if (seats[j]) {
                    middle = false;
                    break;
                }
            }

            // 6,7,8,9
            for (int j = 6; j <= 9; j++) {
                if (seats[j]) {
                    right = false;
                    break;
                }
            }

            // Both sides can fit
            if (left && right) {
                ans -= 0;       // still 2 families
            }

            // One of the three groups can fit
            else if (left || middle || right) {
                ans -= 1;
            }

            // No group can fit
            else {
                ans -= 2;
            }
        }

        return ans;
    }
}