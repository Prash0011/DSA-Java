package binarysearch.bsonanswers;


/*
Platform     : LeetCode
Problem Link : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
Problem      : Minimum Days to make m bouquets
Topic        : Binary Search
Category     : Binary Search on Answers
Difficulty   : Medium

Date last solved : 8 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n)+O(D×n)
Space Complexity : O(1)

*/


// Code


class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = Integer.MAX_VALUE;
        if(bloomDay.length < m*k) {
            return -1;
        }
        int [] findRange = findSmallestAndLargest(bloomDay);
        int start = findRange[0];
        int end = findRange[1];
        for(int i = start; i <= end; i++) {
            int bouquets = countBouquets(i, bloomDay, k);
            if(bouquets >= m) {
                ans = Math.min(ans, i);
            }
        }
        return ans;
    }
        int countBouquets(int start, int [] bloomDay, int k) {
            int totalBloomedFlowers = 0;
            int totalBouquets = 0;
            for(int i = 0; i < bloomDay.length; i++) {
                if(start >= bloomDay[i]) {     // Means flower bloomed on a particular day
                    totalBloomedFlowers++;
                }
                else {
                    totalBloomedFlowers = 0;
                }
                if(totalBloomedFlowers == k) {
                    totalBouquets++;
                    totalBloomedFlowers = 0;
                }
            }
            return totalBouquets;
        }
    
    int [] findSmallestAndLargest(int [] bloomDay) {
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] < min) {
                min = bloomDay[i];
            }
            if(bloomDay[i] > max) {
                max = bloomDay[i];
            }
        }
       return new int [] {min, max};
    }
}


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n)+O(nlogD)
Space Complexity : O(1)

*/


//  Code


class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = Integer.MAX_VALUE;
        if((long)bloomDay.length < (long)m*k) {
            return -1;
        }
        int [] findRange = findSmallestAndLargest(bloomDay);
        int flowerBloomStartDay = findRange[0];
        int flowerBloomEndDay = findRange[1];
        while(flowerBloomStartDay <= flowerBloomEndDay) {
            int flowerBloomMidDay = flowerBloomStartDay + (flowerBloomEndDay - flowerBloomStartDay) / 2;
            int totalBouquets = countBouquets(flowerBloomMidDay, bloomDay, k);
            if(totalBouquets >= m) {
                ans = Math.min(ans, flowerBloomMidDay);
                flowerBloomEndDay = flowerBloomMidDay - 1;
            }
            else {
                flowerBloomStartDay = flowerBloomMidDay + 1;
            }
        }
        return ans;
    }
        int countBouquets(int flowerBloomDay, int [] bloomDay, int k) {
            int totalBloomedFlowers = 0;
            int totalBouquets = 0;
            for(int i = 0; i < bloomDay.length; i++) {
                if(flowerBloomDay >= bloomDay[i]) {     // Means flower bloomed on a particular day
                    totalBloomedFlowers++;
                }
                else {
                    totalBloomedFlowers = 0;
                }
                if(totalBloomedFlowers == k) {
                    totalBouquets++;
                    totalBloomedFlowers = 0;
                }
            }
            return totalBouquets;
        }
    
    int [] findSmallestAndLargest(int [] bloomDay) {
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] < min) {
                min = bloomDay[i];
            }
            if(bloomDay[i] > max) {
                max = bloomDay[i];
            }
        }
       return new int [] {min, max};
    }
}