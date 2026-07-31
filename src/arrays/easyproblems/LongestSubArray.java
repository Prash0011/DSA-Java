package arrays.easyproblems;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-a2z-dsa-track
Problem      : Return length of the longest sub-array 
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 31 July 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        } 
        return ans;
    }
}