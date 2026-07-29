class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length-1;
        int i=0;
        int max=Integer.MIN_VALUE;
        while(i<=n){
            int a=Math.min(arr[i],arr[n])*(n-i);
            max=Math.max(a,max);
            if(arr[i]>arr[n]){
                n--;
            }else{
                i++;
            }
        }

        return max;     
    }
}