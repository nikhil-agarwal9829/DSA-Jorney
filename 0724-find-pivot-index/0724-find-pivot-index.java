class Solution {
    public int pivotIndex(int[] arr) {

        long totalSum = 0;

        for (int x : arr)
            totalSum += x;

        long leftSum = 0;

        for (int i = 0; i < arr.length; i++) {

            long rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum)
                return i;

            leftSum += arr[i];
        }

        return -1;
    }
}
        
    