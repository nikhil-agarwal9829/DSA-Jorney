class Solution {
    public boolean isReachable(int targetX, int targetY) {
        // Calculate the Greatest Common Divisor of targetX and targetY
        int g = gcd(targetX, targetY);
        
        // A number g is a power of 2 if (g & (g - 1)) == 0
        return (g & (g - 1)) == 0;
    }
    
    // Standard Euclidean Algorithm to find GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}