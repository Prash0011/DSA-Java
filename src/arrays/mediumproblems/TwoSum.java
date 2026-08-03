package arrays.mediumproblems;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-a2z-dsa-track
Problem      : Return length of the longest sub-array 
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 02 aug 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }
        }
        return new int [] {-1, -1};
    }
}

/*

Approach         : Better
Time Complexity  : O(n)
Space Complexity : O(n)

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(hm.containsKey(num)) {
                return new int [] {hm.get(num), i};
            }
            else {
                hm.put(nums[i], i);
            }
        }
        return new int [] {-1, -1};
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n log n)
Space Complexity : O(log n)

Note-> This solution is correct for non-negatives

*/

class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);
        while(left < right) {
            if(arr[left] + arr[right] > target) {
                right--;
            }
            else {
                if(arr[left] + arr[right] < target) {
                    left++;
                }
                else {
                    list.add(arr[left]);
                    list.add(arr[right]);
                    return list;
                }
            }
        }
        return list;
    }
}
