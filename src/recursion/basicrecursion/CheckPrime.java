package recursion.basicrecursion;

class Solution {
    public boolean checkPrime(int num) {
        //your code goes here
        if(num < 2) {
            return false;
        }
        int i = 1;
        int factor = 0;
        return isPrime(num, i, factor);
    }
    boolean isPrime(int num, int i, int factor) {
        if(factor > 2) {
            return false;
        }
        if(i > num) {
            return true;
        }
        if(num % i == 0) {
            factor++;
        }
        return isPrime(num, i+1, factor);
    }
}