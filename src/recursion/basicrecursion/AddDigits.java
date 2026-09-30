package recursion.basicrecursion;

class Solution {
    public int addDigits(int num) {
        //your code goes here
        if(num < 10) {
            return num;
        }
        return sum(num);
    }
    int sum(int num) {
        if(num < 10) {
            return num;
        }
        return sum(findSum(num));
    }
    int findSum(int num) {
        int sum = 0;
        while(num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }
}
