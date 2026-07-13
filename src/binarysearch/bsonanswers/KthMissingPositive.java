package binarysearch.bsonanswers;


/*
Platform     : LeetCode
Problem Link : https://leetcode.com/problems/kth-missing-positive-number/description/
Problem      : Kth missing positive integer 
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Easy

Date last solved : 13 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n + k)
Space Complexity : O(1)

*/


// Code

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int count = 0;
        int j = 0;
        int missing = -1;
        while(j < arr.length) {
            if(arr[j] > i) {
                count++;
                if(count == k) {
                    missing = i;
                }
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        if(missing == -1) {
            return arr[j-1] + k - count;
        }
        return missing;
        
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  :O(log n)
Space Complexity : O(1)

*/


//  Code


class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0; 
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int missing = arr[mid] - (mid + 1);
            if(missing < k) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end + 1 + k;
    }
}
