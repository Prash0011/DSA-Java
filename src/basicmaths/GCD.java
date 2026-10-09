package basicmaths;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/practice/dsa/gcd-of-two-numbers
Problem      : Find GCD
Topic        : Basic Maths 
Difficulty   : Core(Medium)

Date last solved : 9 October 2026

Approach         : Brute
Time Complexity  : TC = O(min(n1,n2)) × O(1)
Space Complexity : O(1)

*/

// Search Upward

class Solution {
    public int GCD(int n1, int n2) {
        int i = 2;
        int min = Math.min(n1, n2);
        int ans = 1;
        while(i <= min) {
            if(n1 % i == 0 && n2 % i == 0) {
                ans = Math.max(ans, i);
            }
            i++;
        }
        return ans;
    }
}

/*
Method - 2

Approach         : Better
Time Complexity  : TC = O(min(n1,n2))
Space Complexity : O(1)

*/

// The descending approach: Search downward

class Solution {
    public int GCD(int n1, int n2) {
        int gcd = Math.min(n1, n2);
        while (gcd > 0) {
            if (n1 % gcd == 0 && n2 % gcd == 0) {
                return gcd;
            }
            gcd--;
        }
        return 0;
    }
};


/*
Method - 2

Approach         : Optimal
Time Complexity  : TC = O(log(min(n1,n2)))
Space Complexity : O(1)

*/

class Solution{
    public int GCD(int n1, int n2) {
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        int rem = max % min;
        if(rem == 0) return min;
        int other = min;
        while(rem > 0) {
            int a = rem;
            rem = other % rem;
            other = a;

        }
        return other;
    }
}
