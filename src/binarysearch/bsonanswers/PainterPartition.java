package binarysearch.bsonanswers;

/*
Platform     : GeeksforGeeks/LeetCode(410)
Problem Link : https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
Problem      : Painter Partition Problem
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Medium

Date last solved : 4 June 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n × (sum − max + 1))
Space Complexity : O(1)

*/


// Code

class Solution {
    public int paint(int A, int B, int[] nums) {
       if(A > nums.length) {
            return -1;
        }
        long [] maxAndSum = findMaximumAndSummation(nums);
        long startTime = maxAndSum[0];
        long endTime = maxAndSum[1];
        for(long i = startTime; i < endTime; i++) {
            int painters = findPainters(i, nums);
            if (painters <= A) {
                return (int) ((i * B) % 10000003);
            }
        }
        return -1;
    }    
    int findPainters(long midTime, int [] nums) {
        int painterCount = 1;
        long paintedBoard = 0;
        for(int i = 0; i < nums.length; i++) {
            if(paintedBoard + nums[i] <= midTime) {
                paintedBoard += nums[i];
            }
            else {
                painterCount++;
                paintedBoard  = nums[i]; 
            }

        }
        return painterCount;
    }
    long [] findMaximumAndSummation(int [] nums) {
        int max = nums[0];
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new long [] {max, sum};
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
    public int minTime(int [] nums, int A) {
       if(A > nums.length) {
            return -1;
        }
        long ans = -1;
        long [] maxAndSum = findMaximumAndSummation(nums);
        long startTime = maxAndSum[0];
        long endTime = maxAndSum[1];
        while(startTime <= endTime) {
            long midTime = startTime + (endTime - startTime) / 2;
            int painters = findPainters(midTime, nums);
            if(painters <= A) {
                ans = midTime;
                endTime = midTime - 1;
            }
            else {
                startTime = midTime + 1;
            }

        }
        return (int)(ans);
    }    
    int findPainters(long midTime, int [] nums) {
        int painterCount = 1;
        long paintedBoard = 0;
        for(int i = 0; i < nums.length; i++) {
            if(paintedBoard + nums[i] <= midTime) {
                paintedBoard += nums[i];
            }
            else {
                painterCount++;
                paintedBoard  = nums[i]; 
            }

        }
        return painterCount;
    }
    long [] findMaximumAndSummation(int [] nums) {
        int max = nums[0];
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new long [] {max, sum};
    }
}