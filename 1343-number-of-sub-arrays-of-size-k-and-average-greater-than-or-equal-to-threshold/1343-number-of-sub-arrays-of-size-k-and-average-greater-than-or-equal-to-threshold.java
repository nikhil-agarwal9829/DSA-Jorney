class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int sum=0;
        int n=arr.length;
        for(int i=0;i<k;i++){
            sum+=arr[i];

        }
        if(sum/k>=threshold){
            count++;
        }
        for(int i=0;i<n-k;i++){
            sum-=arr[i];
            sum+=arr[i+k];
            if(sum/k>=threshold){
                count++;
            }

        }
        return count;
        
        
    }
}