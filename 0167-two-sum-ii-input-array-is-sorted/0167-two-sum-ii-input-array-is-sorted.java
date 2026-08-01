class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[]a=new int[2];
        int i=0;
        int k=numbers.length-1;
        while(i<=k){
            if(numbers[i]+numbers[k]==target){
                a[0]=i+1;
                a[1]=k+1;
                break;
        
            }else if(numbers[i]+numbers[k]<target){
                i++;
            }else if(numbers[i]+numbers[k]>target){
                k--;

            }
        }
        return a;
        
    }
}