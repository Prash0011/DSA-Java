package strings.basicandeasystringproblems;

/*

Platform     : LC
Problem Link : https://leetcode.com/problems/largest-odd-number-in-string/
Problem      : Find Largest Odd Number in the String
Topic        : Strings
Difficulty   : Core(Medium)

Date last solved : 11 October 2026

Approach         : Brute
Time Complexity  : TC = O(n)
Space Complexity : O(1)

*/

class Solution {
    public String largestOddNumber(String num) {
        int n = num.length()-1;
        String ans = "";
        while(n >= 0) {
            if(num.charAt(n) % 2 != 0) {
                ans = num.substring(0, n+1);
                int i = 0;
                while(i < ans.length()) {
                    if(ans.charAt(i) == '0') {
                        i++;
                    }
                } 
                return ans.substring(i, n+1);
            }   
            n--;
        }
        return "";
    }
}