package basicmaths;

import java.util.ArrayList;

class Solution {
    public int[] divisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if(n < 2) {
            return new int [] {1};
        }
        list.add(1); 
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                list.add(i);
            }
        }
        list.add(n);
        int [] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
