package binarysearch.bsonanswers;


/*
Platform     : LeetCode
Problem Link : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
Problem      : Smallest Divisor
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Medium

Date last solved : 9 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n × m)
Space Complexity : O(1)

*/


// Code


class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = findLargest(nums);
        for(int i = start; i <= end; i++) {
            int sum = getSum(nums, i);
            if(sum <= threshold) {
                return i;
            }
        }
        return -1;
    }
    int getSum(int [] nums, int divisor) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % divisor == 0) {
                sum = sum + nums[i] / divisor;
            }
            else {
                sum = sum + nums[i] / divisor + 1;
            }
        }
        return sum;
    }
    int findLargest(int [] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n log m)
Space Complexity : O(1)

*/


//  Code

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = findLargest(nums);
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int sum = getSum(nums, mid);
            if(sum <= threshold) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    int getSum(int [] nums, int divisor) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % divisor == 0) {
                sum = sum + nums[i] / divisor;
            }
            else {
                sum = sum + nums[i] / divisor + 1;
            }
        }
        return sum;
    }
    int findLargest(int [] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}