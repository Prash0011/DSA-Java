package binarysearch.bsonanswers;

/*
Platform     : GeeksforGeeks
Problem Link : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
Problem      : Book Allocation
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Hard

Approach   :
Time Complexity  :
Space Complexity :
*/

class Solution {
    public int findPages(int[] nums, int m) {
        if(m > nums.length) {
            return -1;
        }
        int [] maxAndSum = findMaximumAndSummation(nums);
        int startPage = maxAndSum[0];
        int endPage = maxAndSum[1];
        for(int i = startPage; i < endPage; i++) {
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
