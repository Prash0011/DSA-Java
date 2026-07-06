package binarysearch.bsonanswers;

/*
Platform     : GeeksforGeeks
Problem Link : https://www.geeksforgeeks.org/problems/square-root/1
Problem      : Square root of a number
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Easy

Date last solved : 6 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(√n)
Space Complexity : O(1)

*/


// Code

class Solution {
    public int floorSqrt(int n) {
        int sqrt = 1;
        for(int i = 1; i <= n/2; i++) {
            if(i*i <= n) {
                sqrt = i;
            }
            else {
                break;
            }
        }
        return sqrt;
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(log n)
Space Complexity : O(1)

*/


//  Code

class Solution {
    public int floorSqrt(int n) {
        int sqrt = 1;
        int start = 1;
        int end = n / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid*mid <= n) {
                sqrt = mid;
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return sqrt;
    }
}