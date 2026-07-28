class Solution {
    public void sortColors(int[] a) {
        int n=a.length-1;
        int i=0;
        int k=0;
        while(i<=n){
            if(a[i]==0){
                int t=a[i];
                a[i]=a[k];
                a[k]=t;
                i++;
                k++;
                
            }
            else if(a[i]==2){
                int t=a[i];
                a[i]=a[n];
                a[n]=t;
                n--;
            }
            else if(a[i]==1){
                i++;
            }
        
        }
        
    }
}