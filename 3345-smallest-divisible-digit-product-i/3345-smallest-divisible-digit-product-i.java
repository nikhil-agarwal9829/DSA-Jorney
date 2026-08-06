class Solution {
    public int smallestNumber(int n, int t) {
        // if(n<10){
        //     return t;
        // }
        int m=n;
        int sum=1;
        while(true){
            while(n>0){
                int i=n%10;
                sum*=i;
                n/=10;
            }
            if(sum%t==0){
                break;
            }
            n=m+1;
            m++;
            sum=1;
        }
        return m;
    }
}