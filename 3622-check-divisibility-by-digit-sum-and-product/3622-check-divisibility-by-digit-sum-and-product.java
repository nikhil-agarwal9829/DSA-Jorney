class Solution {
    public boolean checkDivisibility(int n) {
        int s=0;
        int m=1;
        int n1=n;
        while(n>0){
            int t=n%10;
            s+=t;
            m*=t;
            n/=10;
        }
     
        if(n1%(s+m)==0){
            return true;
        }
        return false;
        
    }
}