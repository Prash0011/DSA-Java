package hashing.basichashing;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/practice/dsa/highest-occurring-element-in-an-array?tab=problem
Problem      : Find most frequent element
Topic        : Basic Hashing 
Difficulty   : Core(Medium)

Date last solved : 8 October 2026

Approach         : Brute
Time Complexity  : TC = O(n square)
Space Complexity : O(1)

*/

class Solution {
    public int mostFrequentElement(int[] nums) {
        int ans = 0;
        int prevCount = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
            if(count > prevCount) {
                ans = nums[i]; 
                prevCount = count;          
            }
            else {
                if(count == prevCount) {
                    ans = Math.min(ans, nums[i]);
                   
                }    
            }    
        }
        return ans;
    }
}

/*

Approach         : Better
Time Complexity  : TC = O(n log n)
Space Complexity : O(1)

*/

import java.util.Arrays;

class Solution {
    public int mostFrequentElement(int[] nums) {

        Arrays.sort(nums);

        int prevCnt = 0;
        int ans = nums[0];

        int i = 0;

        while (i < nums.length) {
            int cnt = 1;
            int j = i + 1;

            while (j < nums.length && nums[j] == nums[i]) {
                cnt++;
                j++;
            }

            if (cnt > prevCnt ||
                (cnt == prevCnt && nums[i] < ans)) {
                prevCnt = cnt;
                ans = nums[i];
            }

            i = j;
        }

        return ans;
    }
}


/*

Approach         : Optimal
Time Complexity  : TC = O(n)
Space Complexity : O(k)

*/

class Solution {
    public int mostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        int maxFreq = 0;
        int ans = 0;
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(freq > maxFreq || (freq == maxFreq && key < ans)) {
                maxFreq = freq;
                ans = key;
            }
        }
        return ans; 
    }
}




