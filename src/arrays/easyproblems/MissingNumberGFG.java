package arrays.easyproblems;

/*

Platform     : GFG
Problem Link : https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
Problem      : Find missing number in array in the range 1 to n
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 29 July 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    int missingNum(int[] nums) {
        
        int n = nums.length + 1;
        for(int i = 1; i < n; i++) {
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
    int missingNum(int[] nums) {
        
        int n = nums.length + 1;
        int expected = 0;
        for(int i = 1; i <= n; i++) {
            expected += i;
        }
        int current = 0;
        for(int i = 0; i < nums.length; i++) {
            current += nums[i];
        }
        return expected - current;        
    }
}