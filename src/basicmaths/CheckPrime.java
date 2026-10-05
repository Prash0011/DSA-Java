package basicmaths;

// Method 1

class Solution {
    public boolean isPrime(int n) {
          //your code goes here
          if(n < 2) {
            return false;
          }
          int i = 2;
          while(i < n) {
            if(n % i == 0) {
                return false;
            }
            i++;
          }
          return true;
    }
}

// Method 2

class Solution {
    public boolean isPrime(int n) {
          //your code goes here
          if(n < 2) {
            return false;
          }
          int i = 1;
          int facCount = 0;
          while(i <= n) {
            if(n % i == 0) {
                facCount++;
            }
            i++;
          }
          return facCount == 2;
    }
}

