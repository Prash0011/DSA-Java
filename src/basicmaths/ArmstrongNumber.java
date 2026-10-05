package basicmaths;

class Solution {
    static boolean armstrongNumber(int n) {
                                           int cntDigits = countDigits(n);
                                           int temp = n;
                                           int armNum = 0;
                                           while(n > 0) {
                                               int rem = n % 10;
                                               armNum += findNthNumber(rem, cntDigits);
                                               n /= 10;
                                           }
                                           return armNum == temp;
                                       }
                                       static int findNthNumber(int rem, int cntDigits) {
                                           int i = 1;
                                           int ans = 1;
                                           while(i <= cntDigits) {
                                               ans *= rem;
                                               i++;
                                           }
                                           return ans;
                                       }
                                       static int countDigits(int num) {
                                           int cnt = 0;
                                           while(num > 0) {
                                               cnt++;
                                               num /= 10;
                                           }
                                           return cnt;
                                       }
                                   }