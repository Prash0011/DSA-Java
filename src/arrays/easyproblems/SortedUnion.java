package arrays.easyproblems;

import java.util.TreeSet;

/*

Platform     : TUF
Problem Link : https://takeuforward.org/plus/dsa/problems/union-of-two-sorted-arrays?source=strivers-a2z-dsa-track
Problem      : Find sorted union of 2 sorted arrays 
Topic        : Arrays 
Difficulty   : Medium

Date last solved : 27 July 2026

Approach         : Brute
Time Complexity  : O(n1 log n + n2 log n) + O(n1 + n2)
Space Complexity : O(n1 + n2) + O(n1 + n2)

*/

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++) {
            set.add(nums2[j]);
        }
        int [] arr = new int [set.size()];
        int index = 0;
        for(int num : set) {
            arr[index] = num;
            index++;
        }
        return arr;
    }
}


/*

Approach         : Optimal
Time Complexity  : O(n1 + n2)
Space Complexity : O(k)

*/

class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0; 
        int j = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] > nums2[j]){
                if(list.isEmpty() || list.get(list.size() -1) != nums2[j]) {
                     list.add(nums2[j]);                    
                }
                j++;               
            }
            else {
                if(nums1[i] < nums2[j]) {
                    if(list.isEmpty() || list.get(list.size() -1) != nums1[i]) {
                        list.add(nums1[i]);                        
                    }
                    i++;                    
                }
                else {
                   if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                       list.add(nums1[i]);                      
                   }
                    i++;
                    j++;
                }
            }
        }
        while(i < n1) {
            if(list.isEmpty() || list.get(list.size() -1) != nums1[i]) {
                list.add(nums1[i]);                       
            }
            i++;
        }
        while(j < n2) {
           if(list.isEmpty() || list.get(list.size() -1) != nums2[j]) {
                list.add(nums2[j]);
           }
           j++;
        } 
        int [] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        } 
        return arr;   
    }
}
