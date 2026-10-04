package basicmaths;

class Solution {
    public int countOddDigit(int n) {
        int count = 0;
        while(n > 0) {
            int rem = n % 10;
            if(rem % 2 != 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}