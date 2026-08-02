package arrays.easyproblems;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-a2z-dsa-track
Problem      : Return length of the longest sub-array 
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 31 July 2026

Approach         : Brute
Time Complexity  : O(n²)
Space Complexity : O(1)

*/

class Solution {
    public int longestSubarray(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        } 
        return ans;
    }
}


/*

Approach         : Better
Time Complexity  : N log M + O(n/2 + 1)
Space Complexity : O(n/2 + 1)

*/

class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}


/*

Approach         : Optimal
Time Complexity  : O(2n)
Space Complexity : O(1)

Note-> This solution is correct for non-negatives

*/


class Solution {
    public int longestSubarray(int[] nums, int k) {

        int left = 0; 
        int right  = 0;
        int sum = nums[0];
        int maxLen = 0;
        int n = nums.length;
        
        while(right < n) {
            while(left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            if(sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if(right < n) {
                sum += nums[right];
            }
        }
        return maxLen;
    }
}
