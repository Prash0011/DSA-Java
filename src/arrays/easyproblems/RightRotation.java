package arrays.easyproblems;


/*

Platform     : GFG
Problem Link : https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
Problem      : Right rotate the array by one
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 23 July 2026

Approach         : Brute
Time Complexity  : O(n)
Space Complexity : O(n)

*/


class Solution {
    public void rotate(int[] arr) {
        // code here
        int n = arr.length;
        int [] tempArr = new int[n];
        int temp = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            tempArr[i+1] = arr[i];
        }
        tempArr[0] = temp;
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
    public void rotate(int[] arr) {
        // code here
        int n = arr.length;
        int temp = arr[n-1];
    
        for(int i = n-2; i >= 0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = temp;
    }
}
