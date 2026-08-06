class Solution {
    public int minBitFlips(int start, int goal) {
        int x=start^goal;
        int y=Integer.bitCount(x);
        return y;

        

        
    }
}