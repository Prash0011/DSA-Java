package arrays.easyproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/max-consecutive-ones/description/
Problem      : Count maximum consecutive ones
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 30 July 2026

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean b = false;
        int count = 0;
        int ans = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                b = true;
                count++;
            } 
            else {
                b = false;
                ans = Math.max(count, ans);
                count = 0;
            }
            if(i == nums.length-1) {
                ans = Math.max(count, ans);
            }
        }
        return ans;
    }
}