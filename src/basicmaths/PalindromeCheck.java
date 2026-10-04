package basicmaths;

class Solution {
    public boolean isPalindrome(int x) {
        boolean isPdm = false;
        int revNum = 0;
        int num = x;
        while(x > 0) {
            int rem = x % 10;
            revNum = revNum*10 + rem;
            x /= 10;
        }
        return revNum == num;
    }
}