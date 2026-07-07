package binarysearch.bsonanswers;


/*
Platform     : GeeksforGeeks
Problem Link : https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
Problem      : Nth root of a number
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
    public int nthRoot(int N, int M) {
        int ans = -1;
        if(M == 1) {
            return 1;
        }
        if(M == 0) {
            return 0;
        }
        for(int i = 1; i <= M; i++) {
            int j = 0;
            long num = 1;
            while(j < N) {
                num = num*i;
                if(num > M) {
                    break;
                }
                j++;
            }
            if(num == M) {
                ans = i;
            }
        }
        return ans;
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
    public int nthRoot(int N, int M) {
        int ans = -1;
        int start = 1;
        int end = M;
        if(M == 1) {
            return 1;
        }
        if(M == 0) {
            return 0;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long nthRoot = 1;
            int i = 0;
            while(i < N) {
                nthRoot = nthRoot * mid;
                i++;
            }
            if(nthRoot == M) {
                ans = mid;
                break;
            }
            else {
                if(nthRoot > M){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}




