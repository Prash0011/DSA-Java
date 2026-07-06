package binarysearch.bsonanswers;


/*----------------------------------------------------------
OPTIMAL
-----------------------------------------------------------

Approach         : Optimal(Binary-Search)
Time Complexity  : O(n + m)
Space Complexity : O(1)

Date last solved : 6 july 2026

*/

//  Code

class Solution {
    public int kthElement(int[] a, int[] b, int k) {
        int s1 = a.length, s2 = b.length;
        int count = 0;
        int el = -1;
        int i = 0, j = 0;
        while(i < s1 && j < s2) {
            if(a[i] < b[j]) {
                if(count == k-1) {
                    el = a[i];
                }
                count++;
                i++;
            }
            else {
                if(count == k-1) {
                    el = b[j];
                }
                count++;
                j++;
            }            
        }
        while(i < s1) {
            if(count == k-1) {
                el = a[i];
            }
            count++;
            i++;
        }
        while(j < s2) {
            if(count == k-1) {
                el = b[j];
            }
            count++;
            j++;
        }
        return el;
    }
}

