package binarysearch.bsonanswers;


/*
Platform     : LeetCode
Problem Link : https://leetcode.com/problems/koko-eating-bananas/submissions/2058691390/
Problem      : Koko eating bananas
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Medium

Date last solved : 7 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n*m)
Space Complexity : O(1)

*/


// Code


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largest = findLargest(piles);
        for(int i = 1; i <= largest; i++) {
            long hr = findHours(i, piles);
            if(hr <= h) {
                return i;
            }
        }
        return -1;
    }
    long findHours(int num, int [] piles) {
        long hour = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] % num == 0) {
                hour = hour + piles[i] / num;
            } 
            else {
                hour = hour + piles[i] / num + 1;
            }
        }
        return hour;
    }
    int findLargest(int [] piles) {
        int max = piles[0];
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(NlogM)
Space Complexity : O(1)

*/


//  Code


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = findLargest(piles);
        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long hr = findHours(mid, piles);
            if(hr <= h) {
                ans = Math.min(mid, ans);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    long findHours(int num, int [] piles) {
        long hour = 0;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] % num == 0) {
                hour = hour + piles[i] / num;
            } 
            else {
                hour = hour + piles[i] / num + 1;
            }
        }
        return hour;
    }
    int findLargest(int [] piles) {
        int max = piles[0];
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
}

