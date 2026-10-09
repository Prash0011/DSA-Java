package basicmaths;

// Method -1
 
/*

Platform     : TUF
Problem Link : https://takeuforward.org/practice/dsa/lcm-of-two-numbers
Problem      : Find LCM
Topic        : Basic Maths 
Difficulty   : Core(Medium)

Date last solved : 8 October 2026

Approach         : Brute
Time Complexity  : TC = O(LCM(n1,n2))
Space Complexity : O(1)

*/

class Solution {
    public int LCM(int n1, int n2) {  
        int ans = Math.max(n1, n2);
        while(ans % n1 != 0 || ans % n2 != 0) {
            ans++;
        }
        return ans;
    }
}

/*
Method - 2

Approach         : Better
Time Complexity  : TC=O(min(n1,n2)​/GCD(n1,n2))
Space Complexity : O(1)

*/

class Solution {
    public int LCM(int n1, int n2) {  
        int ans = Math.max(n1, n2);
        while(ans % Math.min(n1, n2) != 0 ) {
            ans += Math.max(n1, n2);
        }
        return ans;
    }
}

/*
Method - 2

Approach         : Optimal
Time Complexity  : TC=O(min(n1,n2)​/GCD(n1,n2))
Space Complexity : O(1)

*/

class Solution {
    public int LCM(int n1, int n2) {  
        int gcd = findGCD(n1, n2);
        return (n1*n2) / gcd;
    }
    int findGCD(int n1, int n2) {
        int ans = 1;
        int i = 2;
        while(i <= Math.min(n1, n2)) {
            if(n1 % i == 0 && n2 % i == 0) {
                ans = i;
            }
            i++;
        }
        return ans;
    }
}
