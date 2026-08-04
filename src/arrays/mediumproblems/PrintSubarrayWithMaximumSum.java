package arrays.mediumproblems;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int ansStart = -1;
        int ansEnd = -1;
        int sum = 0;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {  
            if(sum == 0) {
                start = i;
            }      
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return ansEnd - ansStart;
    }
}
