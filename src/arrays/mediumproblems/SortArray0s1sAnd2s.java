package arrays.mediumproblems;

/*

Approach         : Better
Time Complexity  : O(2n)
Space Complexity : O(n)- Just modifying the given array

*/

class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count0++;
            }
            else {
                if(nums[i] == 1) {
                    count1++;
                }
                else {
                    count2++;
                }
            }
        }
        for(int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for(int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for(int i = count0 + count1; i < count0 + count1 + count2; i++) {
            nums[i] = 2;
        }
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n)
Space Complexity : O(1)

*/

class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            }
            else {
                if(nums[mid] == 1) {
                    mid++;
                }
                else {
                    swap(nums, mid, high);
                    high--;
                }
            }
            
        }
        
    }
    void swap(int [] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
    }
}

