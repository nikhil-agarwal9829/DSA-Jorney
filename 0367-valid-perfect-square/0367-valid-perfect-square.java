class Solution {
    public boolean isPerfectSquare(int x) {
        if (x < 2) return true;
        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid == x) return true;
            else if ((long)mid * mid < x) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }
}

        
