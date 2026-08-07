package arrays.easyproblems;

import java.util.ArrayList;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/move-zeroes/description/
Problem      : Move zeros to end 
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 24 July 2026

Approach         : Brute
Time Complexity  : O(2n)
Space Complexity : O(x) -> o(n) in worst case in case of no 0

*/

class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for(int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}



/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		j = i;
        		break;
        	}
        }
        if(j == -1) {
        	return;
        }
        for(int i = j+1; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}


// My Solution/Approach

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
            else {
                i++;
            }
        }
    }
}
