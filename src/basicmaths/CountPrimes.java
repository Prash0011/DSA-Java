package basicmaths;

// Method 1

class Solution {
    public int primeUptoN(int n) {
        if(n < 2) {
            return 0;
        }
        int count = 0;
        int i = 2;
        while(i <= n) {
            if(isPrime(i)) {
                count++;
            }
            i++;
        }
        return count;
    }
    boolean isPrime(int num) {
        boolean b = false;
        int i = 2;
        while(i < num) {
            if(num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}

// Method 2

class Solution {
    public int countPrimes(int n) {
        if(n < 2) {
            return 0;
        }
        boolean [] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i*i < n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int countPrimes = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                countPrimes++;
            }
        }
        return countPrimes;
    }
}