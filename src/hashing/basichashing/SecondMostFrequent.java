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
    public int secondMostFrequentElement(int[] nums) {
        int maxEl = -1;
        int maxCnt = 0;
        int secMaxEl = -1;
        int secMaxCnt = 0;
        for(int i = 0; i < nums.length; i++) {
            int curEl = nums[i];
            int curCnt = 0;
            for(int j = 0; j < nums.length; j++) {
                if(curEl == nums[j]) {
                    curCnt++;
                }
            }
            if(curCnt > maxCnt) {
                secMaxCnt = maxCnt;
                secMaxEl = maxEl;
                maxCnt = curCnt;
                maxEl = curEl;
            }
            else {
                if(curCnt == maxCnt) {
                    maxEl = Math.min(maxEl, curEl);
                }
                else {
                    if(curCnt > secMaxCnt) {
                        secMaxCnt = curCnt;
                        secMaxEl = curEl;
                    }
                    else {
                        if(curCnt == secMaxCnt) {
                            secMaxEl = Math.min(secMaxEl, curEl);
                        }
                    }
                }
            }
        }
        return secMaxEl;
    }
}

/*

Approach         : Better
Time Complexity  : TC = O(n log n)
Space Complexity : O(1)

*/

class Solution {
    public int secondMostFrequentElement(int[] nums) {
        Arrays.sort(nums);
        int maxEl = -1;
        int maxCnt = 0;
        int secMaxEl = -1;
        int secMaxCnt = 0;
        int i = 0;
        while(i < nums.length) {
            int j = i+1;
            int curEl = nums[i];
            int curCnt = 1; 
            while(j < nums.length && curEl == nums[j]) {
                curCnt++;
                j++;
            }

            if(curCnt > maxCnt) {
                secMaxCnt = maxCnt;
                secMaxEl = maxEl;
                maxCnt = curCnt;
                maxEl = curEl;
            }
            else {
                if(curCnt < maxCnt) {  // maxCnt wouldn't change
                    if(curCnt > secMaxCnt) {
                        secMaxCnt = curCnt;
                        secMaxEl = curEl;
                    }
                    else {
                        if(curCnt == secMaxCnt) {
                            secMaxEl = Math.min(secMaxEl, curEl);
                        }
                    }
                }
                else {
                    maxEl = Math.min(maxEl, curEl);
                }
            }
            i = j;
        }
        return secMaxEl;
    }
}

/*

Approach         : Optimal
Time Complexity  : TC = O(n)
Space Complexity : O(n)

*/

class Solution {
    public int secondMostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        int maxEl = -1;
        int maxFreq = 0;
        int secMaxEl = -1;
        int secMaxFreq = 0;
        int i = 0;
        for(int key : map.keySet()) {
            int curFreq = map.get(key);
            int curEl = key;
            if(curFreq > maxFreq) {
                secMaxFreq = maxFreq;
                secMaxEl = maxEl;
                maxFreq = curFreq;
                maxEl = curEl;
            }
            else {
                if(curFreq < maxFreq) {
                    if(curFreq > secMaxFreq) {
                        secMaxFreq = curFreq;
                        secMaxEl = curEl;
                    }
                    else {
                        if(curFreq == secMaxFreq) {
                            secMaxEl = Math.min(secMaxEl, curEl);
                        }
                    }
                }
                else { // means maxFreq == curFreq
                    maxEl = Math.min(maxEl, curEl);
                }
            }
        }
        return secMaxEl;
    }
}


