package arrays.mediumproblems;

/*

Platform     : LeetCode
Problem Link : https://leetcode.com/problems/maximum-subarray/description/
Problem      : Find majority element that apperas more than n/2 times
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 4 July 2026

Approach         : Brute
Time Complexity  : O(n suare)
Space Complexity : O(1)

*/

class Solution {
    public int maxProfit(int[] prices) {
        int ansProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            int buyPrice = prices[i];
            for(int j = i+1; j < prices.length; j++) {
                int sellPrice = prices[j];
                int profit = sellPrice - buyPrice;
                ansProfit = Math.max(ansProfit, profit);
            }
        }
        return ansProfit;
    }
}

/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1) 

*/

class Solution {
    public int maxProfit(int[] prices) {
        int ansProfit = 0;
        int mini = prices[0];
        for(int i = 1; i < prices.length; i++) {
            int sellPrice = prices[i] - mini;
            ansProfit = Math.max(ansProfit, sellPrice);
            mini = Math.min(mini, prices[i]);
        }
        return ansProfit;
    }
}
