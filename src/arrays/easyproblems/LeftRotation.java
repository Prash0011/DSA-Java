package arrays.easyproblems;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/plus/dsa/problems/left-rotate-array-by-one?source=strivers-a2z-dsa-track
Problem      : Left rotate the array by one
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 23 July 2026

Approach         : Brute
Time Complexity  : O(n)
Space Complexity : O(n)

*/


class Solution {
    public void rotateArrayByOne(int[] arr) {
        int first = arr[0];
        int length = arr.length;
        int [] tempArr = new int[length];
        for(int i = 1; i < length; i++) {
            tempArr[i-1] = arr[i];
        }
        tempArr[length-1] = first; 
        for(int i = 0; i < tempArr.length; i++) {
            arr[i] = tempArr[i];
        }
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/


class Solution {
    public void rotateArrayByOne(int[] arr) {
        int first = arr[0];
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = first; 
    }
}
