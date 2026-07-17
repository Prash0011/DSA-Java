package strings.basicandeasystringproblems;

/*

Platform     : GeeksforGeeks/LeetCode
Problem Link : https://leetcode.com/problems/remove-outermost-parentheses/description/
Problem      : Remove Outermost Parenthesis
Topic        : String 
Category     : Basic and Easy problems
Difficulty   : Easy

Date last solved : 15 July 2026

*/

/*----------------------------------------------------------
BRUTE FORCE
-----------------------------------------------------------

Approach         : Brute Force
Time Complexity  : O(n²)
Space Complexity : O(n)

*/

class Solution {
    public String removeOuter(String s) {
        int count = 0;
        String ans = "";
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == ')') {
                count--;
            }
            if(count != 0) {
                ans += s.charAt(i);
            }
            if(s.charAt(i) == '(') {
                count++;
            }
        }
        return ans;
    }
}



/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n)
Space Complexity : O(n)

*/


//  Code


class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                count--;
            }
            if(count != 0) {
                ans.append(s.charAt(i));
            }
            if(s.charAt(i) == '(') {
                count++;
            }
        }
        return ans.toString();
    }
}
