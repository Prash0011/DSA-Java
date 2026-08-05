package arrays.mediumproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/maximum-subarray/description/
Problem      : Find majority element that apperas more than n/2 times
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 4 July 2026

Approach         : Brute
Time Complexity  : O(n) here 2 pass needed
Space Complexity : O(n)

*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int [] posEl = new int [n/2];
        int [] negEl = new int[n/2];
        int j = 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                posEl[j++] = nums[i];
            }
            else {
                negEl[k++] = nums[i];
            }
        }
        int [] ansEl = new int[n];
        int l = 0;
        int m = 0;
        int o = 0;
        while(l < n) {
            if(l % 2 == 0) {
                // add positives
                ansEl[l++] = posEl[m++];
            }
            else {
                ansEl[l++] = negEl[o++];
            }
        }
        return ansEl;
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n) here only one pass needed
Space Complexity : O(n) Extra space

*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int posIndex = 0;
        int negIndex = 1;
        int [] ans = new int [n];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
            else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return ans;
    }
}
