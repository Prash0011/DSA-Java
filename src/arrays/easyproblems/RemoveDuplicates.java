package arrays.easyproblems;

import java.util.LinkedHashSet;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
Problem      : Remove Duplicates from sorted array
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 22 July 2026

Approach         : Brute Force
Time Complexity  : O(n log n + n)
Space Complexity : O(n)

*/

class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int i = 0;
        for(int num : set) {
            nums[i++] = num;
        }
        return set.size();
    }
}

/*
 
Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/


class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}
