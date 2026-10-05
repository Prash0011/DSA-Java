package basicmaths;

class Solution {
    public boolean checkPerfectNumber(int num) {
        int divisorSum = 0;
        int i = 1;
        while(i <= num/2) {
            if(num % i == 0) {
                divisorSum += i;
            }
            i++;
        }
        return divisorSum == num;
    }
}
