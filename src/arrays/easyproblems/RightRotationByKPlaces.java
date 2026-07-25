package arrays.easyproblems;


/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/rotate-array/description/
Problem      : Right rotation by k places
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 24 July 2026

Approach         : Brute
Time Complexity  : O(n+d)
Space Complexity : O(d)

*/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int [] tempArr = new int[k];
        int j = 0;
        for(int i = n - k; i < n; i++) {
            tempArr[i - (n-k)] = nums[i];
        }
        for(int i = n - k - 1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }
        int l = 0;
        for(int i = 0; i < k; i++) {
            nums[i] = tempArr[i];
            l++;
        }
    }
}


/*

Approach         : Optimal
Time Complexity  : O(2n)
Space Complexity : O(1)

*/


class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n-1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    void reverse(int [] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
