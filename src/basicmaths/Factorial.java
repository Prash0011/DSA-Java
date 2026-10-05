package basicmaths;

class Solution {
    public int factorial(int n) {
        if(n < 3) {
            return 2;
        }
        int i = 2;
        int fact = 1;
        while(i <= n) {
            fact *= i;
        }
        return fact;
    }
}
