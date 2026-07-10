package binarysearch.bsonanswers;


/*
Platform     : LeetCode
Problem Link : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/submissions/2062477200/
Problem      : Capacity to ship packages with in d days 
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Medium

Date last solved : 10 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(nS)
Space Complexity : O(1)

*/


// Code


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int []  range = findRange(weights);
        int start = range[0];
        int end = range[1];
        int ans = Integer.MAX_VALUE;
        for(int shipCap = start; shipCap <= end; shipCap++) {
            int totalDays = getTotalDays(weights, shipCap);
            if(totalDays <= days) {
                ans = Math.min(ans, shipCap);
            }
        }
        return ans;
    }
    int getTotalDays(int [] weights, int shipCap) {
        int weightSum = 0;
        int days = 0;
        for(int i = 0; i < weights.length; i++) {
            weightSum += weights[i];
            if(weightSum > shipCap) {
                days++;
                weightSum = weights[i];
            }
        }
         if(weightSum > 0) {
            days++;
        }
        return days;
    }
    int [] findRange(int [] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return new int [] {max, sum};
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n log S)
Space Complexity : O(1)

*/


//  Code

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int []  range = findRange(weights);
        int startCap = range[0];
        int endCap = range[1];
        int ans = Integer.MAX_VALUE;
        while(startCap <= endCap) {
            int midCap = startCap + (endCap - startCap) / 2;
            int totalDays = getTotalDays(weights, midCap);
            if(totalDays <= days) {
                ans = Math.min(ans, midCap);
                endCap = midCap - 1;
            }
            else {
                startCap = midCap + 1;
            }
        }
        return ans;
    }
    int getTotalDays(int [] weights, int shipCap) {
        int weightSum = 0;
        int days = 0;
        for(int i = 0; i < weights.length; i++) {
            weightSum += weights[i];
            if(weightSum > shipCap) {
                days++;
                weightSum = weights[i];
            }
        }
         if(weightSum > 0) {
            days++;
        }
        return days;
    }
    int [] findRange(int [] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return new int [] {max, sum};
    }
}