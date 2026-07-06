package binarysearch.bsonanswers;


/*
Platform     : GeeksforGeeks/LeetCode(410)
Problem Link : https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1
Problem      : Split Array Largest Sum
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Hard

Date last solved : 3 June 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n × (sum − max + 1))
Space Complexity : O(1)

Date last solved : 3 July 2026

*/


// Code


class Solution {
    public int splitArray(int[] a, int k) {
        if(k > a.length) {
            return -1;
        }
        int [] maxAndSum = findMaximumAndSummation(a);
        int start = maxAndSum[0];
        int end = maxAndSum[1];
        for(int i = start; i <= end; i++) {
            int subArrays = findTotalSubArrays(i, a);
            if(subArrays <= k){
                return i;
            }
        }
        return -1;
    }
    int findTotalSubArrays(int sum, int [] nums) {
        int countSubArrays = 1;
        int subArraysSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(subArraysSum + nums[i] <= sum) {
                subArraysSum += nums[i];
            }
            else {
                countSubArrays++;
                subArraysSum = nums[i];
            }
        }
        return countSubArrays;
    }
    int [] findMaximumAndSummation(int [] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new int [] {max, sum};
    }
}



/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n*log(sum-max+1))
Space Complexity : O(1)

*/


//  Code

class Solution {
    public int splitArray(int[] a, int k) {
        if(k > a.length) {
            return -1;
        }
        int ans = -1;
        int [] maxAndSum = findMaximumAndSummation(a);
        int start = maxAndSum[0];
        int end = maxAndSum[1];
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int subArrays = findTotalSubArrays(mid, a);
            if(subArrays <= k){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    int findTotalSubArrays(int sum, int [] nums) {
        int countSubArrays = 1;
        int subArraysSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(subArraysSum + nums[i] <= sum) {
                subArraysSum += nums[i];
            }
            else {
                countSubArrays++;
                subArraysSum = nums[i];
            }
        }
        return countSubArrays;
    }
    int [] findMaximumAndSummation(int [] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new int [] {max, sum};
    }
}

