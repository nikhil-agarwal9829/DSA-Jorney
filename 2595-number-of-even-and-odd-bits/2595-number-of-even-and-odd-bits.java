class Solution {
    public int[] evenOddBit(int n) {
        int e=0;
        int o=0;
        int c=0;

        while(n>0){
            int i=n&1;
            if((c&1)==1){
                e+=i;
            }else{
                o+=i;

            }
            n>>=1;
            c++;
            
        }
        int ab[]=new int[2];
        ab[0]=o;
        ab[1]=e;
        return ab;
    }
}