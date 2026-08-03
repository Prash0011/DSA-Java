package arrays.mediumproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/majority-element/description/
Problem      : Find majority element that apperas more than n/2 times
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 3 July 2026

Approach         : Brute
Time Complexity  : O(n square)
Space Complexity : O(1)

*/

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            int freq = 0;
            for(int j= 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                }
                
            }
            if(freq > n/2) {
                return nums[i];
            }
        }
        return -1;
    }
}

/*

Approach         : Better
Time Complexity  : O(n)
Space Complexity : O(n) 

*/

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()) {
            if(map.get(key) > n/2) {
                return key;
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
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int el = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                el = nums[i];
                count = 1;
            }
            else {
                if(el == nums[i]) {
                    count++;
                }
                else {
                    count--;
                }
            }
        }
        return el;
    }
}