package recursion.basicrecursion;

class Solution {
    public int arraySum(int[] nums) {
        //your code goes here
        int i = 0;
        int sum = 0;
        return arraySum(nums, i, sum);
    }
    int arraySum(int [] nums, int i, int sum) {
        if(i >= nums.length) {
            return sum;
        }
        sum += nums[i];
        return arraySum(nums, i+1, sum);
    }
}
