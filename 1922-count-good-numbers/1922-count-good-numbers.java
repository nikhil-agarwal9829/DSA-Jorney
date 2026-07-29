class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = power(5, evenPos);
        long oddWays = power(4, oddPos);

        return (int) ((evenWays * oddWays) % MOD);
    }

    private long power(long x, long n) {

        long ans = 1;

        while (n > 0) {

            if ((n & 1) == 1) {
                ans = (ans * x) % MOD;
            }

            x = (x * x) % MOD;
            n >>= 1;
        }

        return ans;
    }
}