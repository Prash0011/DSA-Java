package arrays.easyproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/single-number/description/
Problem      : Find single number in the array 
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 30 July 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    public int singleNumber(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[j] == nums[i]) {
                    count++;
                }
            }
            if(count == 1) {
                return nums[i];
            }
        }
        return -1;   
    }
}


/*

Approach         : Better
Time Complexity  : N log M + O(n/2 + 1)
Space Complexity : O(n/2 + 1)

*/

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        } 
        for(int num : nums) {
            if(map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
