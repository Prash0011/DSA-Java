package recursion.basicrecursion;

class Solution {
    public boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here
        int i = 0;
        int n = nums.size()-1;
        return sorted(nums, i, n);
    }
    boolean sorted(ArrayList<Integer> nums, int i, int n) {
        if(i >= n) {
            return true;
        }
        if(nums.get(i) > nums.get(i+1)) {
            return false;
        }
        return sorted(nums, i+1, n);
    }
}