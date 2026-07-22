package arrays.easyproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
Problem      : Check if array is sorted and rotated
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 22 July 2026

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public boolean check(int[] nums) {
        int breakPoint = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                breakPoint++;
            }
        }
        if(nums[0] < nums[nums.length-1]) {
            breakPoint++;
        }
        return breakPoint <= 1;
    }
}