package arrays.easyproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/missing-number/
Problem      : Find missing number in array in the range 0 to n
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 29 July 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    public int missingNumber(int[] nums) {
        int  num = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == i) {
                    count++;
                }
            }
            if(count <= 0) {
                return i;
            }
        }
        return n;        
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/


class Solution {
    public int missingNumber(int[] nums) {
        int  num = 0;
        int n = nums.length;
        int expected = 0;
        for(int i = 0; i <= n; i++) {
            expected += i;
        }
        int current = 0;
        for(int i = 0; i < n; i++) {
            current += nums[i];
        }
        return expected - current;        
    }
}
