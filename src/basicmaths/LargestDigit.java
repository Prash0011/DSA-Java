package basicmaths;

class Solution {
    public int largestDigit(int n) {
        int ans = 0;
        while(n > 0) {
            int rem = n % 10;
            ans = Math.max(ans, rem);
            n /= 10;
        }
        return ans;
    }
}
