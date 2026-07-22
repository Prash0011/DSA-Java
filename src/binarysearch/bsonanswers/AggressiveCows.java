package binarysearch.bsonanswers;

import java.util.Arrays;

/*

Platform     : GeeksforGeeks/LeetCode(4)
Problem Link : https://www.geeksforgeeks.org/problems/aggressive-cows/1
Problem      : Aggressive Cows
Topic        : Binary Search
Category     : Binary Search On Answers
Difficulty   : Hard

Date last solved : 15 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n(log n + d))
Space Complexity : O(1)

*/

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int start = 1;
        int end = nums[nums.length-1] - nums[0];
        for(int i = start; i <= end; i++) {
            int cntCows = countCows(nums, i);
            if(cntCows >= k) {
                ans = i;
            }
        }
        return ans;
    }
    int countCows(int [] nums, int dist) {
        int totalCows = 1;
        int last = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - last >= dist) {
                totalCows++;
                last = nums[i];
            }
        }
        return totalCows;
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(nlog n + nlog d)
Space Complexity : O(n)

*/


//  Code

class Solution {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int start = 1;
        int end = nums[nums.length-1] - nums[0];
        while(start <= end) {
            int mid = start + (end - start)/2;
            int cntCows = countCows(nums, mid);
            if(cntCows >= k) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
    int countCows(int [] nums, int dist) {
        int totalCows = 1;
        int last = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - last >= dist) {
                totalCows++;
                last = nums[i];
            }
        }
        return totalCows;
    }
}

