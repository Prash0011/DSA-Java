package binarysearch.bsonanswers;


/*
Platform     : GeeksforGeeks/LeetCode(4)
Problem Link : https://leetcode.com/problems/median-of-two-sorted-arrays/
Problem      : Median Of 2 Sorted Arrays
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Hard

Date last solved : 5 June 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O((n + m) log(n + m))
Space Complexity : O(n + m)

*/


// Code


// BruteForce-1

import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ind = 0;
        double [] nums = new double[nums1.length + nums2.length];
        for(int i = 0; i < nums1.length; i++) {
            nums[ind++] = nums1[i];
        }
        for(int i = 0; i < nums2.length; i++) {
            nums[ind++] = nums2[i];
        }
        Arrays.sort(nums);
        if(nums.length % 2 != 0) {
            return nums[nums.length / 2];
        }
        else {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        }
    }
}


// BruteForce-2


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ind = 0;
        double [] nums3 = new double[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                nums3[ind++] = nums2[j++];
            }
            else {
                nums3[ind++] = nums1[i++];
            }
        }
        while(i < nums1.length) {
            nums3[ind++] = nums1[i++];
        }
        while(j < nums2.length) {
            nums3[ind++] = nums2[j++];
        }
        if(nums3.length % 2 != 0) {
            return nums3[nums3.length / 2];
        }
        else {
            return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2;
        }
    }
}





/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n + m)
Space Complexity : O(1)

*/


//  Code


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length + nums2.length;
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int count = 0;
        int ind1el = -1;
        int ind2el = -1;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] > nums2[j]) {
                if(count == ind1) {
                    ind1el = nums2[j];
                }
                if(count == ind2) {
                    ind2el = nums2[j];
                }
                count++;
                j++;
                
            }
            else {
                if(count == ind1) {
                    ind1el = nums1[i];
                }
                if(count == ind2) {
                    ind2el = nums1[i];
                }
                count++;
                i++;
            }
        }
        while(i < nums1.length) {
            if(count == ind1) {
                    ind1el = nums1[i];
                }
                if(count == ind2) {
                    ind2el = nums1[i];
                }
                count++;
                i++;
        }
        while(j < nums2.length) {
            if(count == ind1) {
                    ind1el = nums2[j];
            }
            if(count == ind2) {
                ind2el = nums2[j];
            }
            count++;
            j++;
        }
        if(n % 2 != 0) {
            return ind2el;
        }
        else {
            return (ind1el + ind2el) / 2.0;
        }
    }
}

