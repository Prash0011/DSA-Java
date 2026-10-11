package strings.basicandeasystringproblems;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/practice/dsa/highest-occurring-element-in-an-array?tab=problem
Problem      : Find most frequent element
Topic        : Strings
Difficulty   : Core(Medium)

Date last solved : 11 October 2026

Approach         : Brute
Time Complexity  : TC = O(n square)
Space Complexity : O(n)

*/

class Solution {
    public boolean isPalindrome(String s) {
        int n = 0;
        String str = "";
        while(n < s.length()) {
            char ch = Character.toLowerCase(s.charAt(n));
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                str += ch;
            }
            n++;
        }
        int left = 0;
        int right = str.length()-1;
        while(left <= right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/*

Approach         : Optimal
Time Complexity  : TC = O(n)
Space Complexity : O(1)

*/

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right) {
            char chLeft = Character.toLowerCase(s.charAt(left));
            char chRight = Character.toLowerCase(s.charAt(right));
            if((chLeft >= 'a' && chLeft <= 'z') || (chLeft >= '0' && chLeft <= '9')) {
                if((chRight >= 'a' && chRight <= 'z') || (chRight >= '0' && chRight <= '9')) {
                    if(chLeft != chRight) {
                        return false;
                    }
                    else {
                        left++;
                        right--;
                    }   
                }
                else {
                    right--;    
                }
            } 
            else {
                left++;
            }
        }
        return true;
    }
}
