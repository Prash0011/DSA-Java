package arrays.easyproblems;

/*

Platform     : GeeksforGeeks
Problem Link : https://www.geeksforgeeks.org/problems/second-largest3735/1
Problem      : Second Largest element in the array
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 22 July 2026

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/


class Solution {
    public int getSecondLargest(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;
        for(int  i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                sl = max;
                max = nums[i];
            }
            else {
                if(nums[i] < max && nums[i] > sl) {
                    sl = nums[i];
                }
            }
        }
        if(sl == Integer.MIN_VALUE) {
            return -1;
        }
        return sl;
    }
}
