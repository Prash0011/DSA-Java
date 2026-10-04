package basicmaths;

class Solution {
    public int countDigit(int n) {
        int digits = 0;
        if( n < 10) {
            return 1;
        }
        while(n > 0) {
            digits++;
            n /= 10;
        }
        return digits;
    }
}