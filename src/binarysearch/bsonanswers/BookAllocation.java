package binarysearch.bsonanswers;

/*
Platform     : GeeksforGeeks
Problem Link : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
Problem      : Book Allocation
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Hard

Date last solved : 3 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n × (sum − max + 1))
Space Complexity : O(1)

*/


// Code

class Solution {
    public int findPages(int[] nums, int m) {
        if(m > nums.length) {
            return -1;
        }
        int [] maxAndSum = findMaximumAndSummation(nums);
        int startPage = maxAndSum[0];
        int endPage = maxAndSum[1];
        for(int i = startPage; i <= endPage; i++) {
            if(isAllocationPossible(i, nums, m)) {
                return i;
            }
        }
        return -1;
    }
    boolean isAllocationPossible(int pages, int [] nums, int m) {
        int countStudent = 1;
        int assignedPages = 0;
        for(int i = 0; i < nums.length; i++) {
            if(assignedPages + nums[i] <= pages) {
                assignedPages += nums[i];
                continue;
            }
            else {
                countStudent++;
                assignedPages = nums[i];
            }
        }
        if(countStudent <= m) {
            return true;
        }
        else {
            return false;
        }
    }
    int [] findMaximumAndSummation(int [] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new int [] {max, sum};
    }
}



/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n × log(sum − max + 1))
Space Complexity : O(1)

*/


//  Code

class Solution {
    public int findPages(int[] nums, int m) {
        if(m > nums.length) {
            return -1;
        }
       long ans = -1;
       long [] maxAndSum = findMaximumAndSummation(nums);
       long startPage = maxAndSum[0];
       long endPage = maxAndSum[1];
        while(startPage <= endPage) {
            long midPage = startPage + (endPage- startPage)/2;
            int stuCount = findAllocatedStudents(midPage, nums);
            if(stuCount <= m) {
                ans = midPage;
                endPage = midPage-1;
            }
            else {
                startPage = midPage + 1;
            }
        }
        return (int)ans;
    }
    int findAllocatedStudents(long pages, int [] nums) {
        int countStudent = 1;
        long assignedPages = 0;
        for(int i = 0; i < nums.length; i++) {
            if(assignedPages + nums[i] <= pages) {
                assignedPages += nums[i];
            }
            else {
                countStudent++;
                assignedPages = nums[i];
            }
        }
        return countStudent;
    }
    long [] findMaximumAndSummation(int [] nums) {
        long max = nums[0];
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new long [] {max, sum};
    }
}

