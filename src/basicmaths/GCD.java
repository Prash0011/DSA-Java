package basicmaths;

class Solution {
    public int GCD(int n1, int n2) {
        int i = 2;
        int min = Math.max(n1, n2);
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
