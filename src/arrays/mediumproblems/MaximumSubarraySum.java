package arrays.mediumproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/maximum-subarray/description/
Problem      : Find majority element that apperas more than n/2 times
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 4 July 2026

Approach         : Brute
Time Complexity  : O(n cube)
Space Complexity : O(1)

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {        
            for(int j = i; j < nums.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                
                maxSum = Math.max(maxSum, sum);                
            }
            
        }
        return maxSum;
    }
}


/*

Approach         : Better
Time Complexity  : O(n square)
Space Complexity : O(n) 

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);                
            }
            
        }
        return maxSum;
    }
}


/*

Approach         : Optimal (Kadane's  Algorithm)
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {        
            sum += nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
