package arrays.easyproblems;


/*

Platform     : GFG
Problem Link : https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1
Problem      : Left rotation by k places
Topic        : Arrays 
Difficulty   : Easy

Date last solved : 24 July 2026

Approach         : Brute
Time Complexity  : O(n+d)
Space Complexity : O(d)

*/



class Solution {
    public void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n;
        int [] temp = new int[d];
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i]; 
        }
        for(int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }
        for(int i = n-d; i < n; i++) {
            arr[i] = temp[i - (n-d)];
        }
    }
}


/*

Approach         : Optimal
Time Complexity  : O(2n)
Space Complexity : O(1)

*/


class Solution {
    public void rotateArr(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n;
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }
    void reverseArray(int [] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
