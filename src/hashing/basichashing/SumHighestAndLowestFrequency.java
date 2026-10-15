package hashing.basichashing;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/practice/dsa/second-highest-occurring-element
Problem      : Find second most frequent element
Topic        : Basic Hashing 
Difficulty   : Core(Medium)

Date last solved : 14 October 2026

Approach         : Brute
Time Complexity  : TC = O(n square)
Space Complexity : O(1)

*/

class Solution {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int curEl = nums[i];
            int curFreq = 0;
            for(int j = 0; j < nums.length; j++) {
                if(curEl == nums[j]) {
                    curFreq++;
                }
            }
            if(curFreq > maxFreq) {
                maxFreq = curFreq;
            }
            if(curFreq < minFreq) {
                minFreq = curFreq;
            }
        }
        return maxFreq + minFreq;
    }
}

/*

Approach         : Better
Time Complexity  : TC = O(n log n)
Space Complexity : O(1)

*/

class Solution {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length) {
            int j = i+1;
            int curEl = nums[i];
            int curFreq = 1;
            while(j < nums.length && curEl == nums[j]) {
                curFreq++;
                j++;
            }
            if(curFreq > maxFreq) {
                maxFreq = curFreq;
            }
            if(curFreq < minFreq) {
                minFreq = curFreq;
            }
            i = j;
        }
        return maxFreq + minFreq;
    }
}

/*

Approach         : Optimal
Time Complexity  : TC = O(n)
Space Complexity : O(n)

*/

class Solution {
    public int sumHighestAndLowestFrequency(int[] nums) {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        for(int key : map.keySet()) {
            int curFreq = map.get(key);
            if(curFreq > maxFreq) {
                maxFreq = curFreq;
            }
            if(curFreq < minFreq) {
                minFreq = curFreq;
            }
        }
        return maxFreq + minFreq;
    }
}

