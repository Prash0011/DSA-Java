package arrays.mediumproblems;

import java.util.ArrayList;

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) >= 0) {
                posList.add(arr.get(i));
            }
            else {
                negList.add(arr.get(i));
            }
        }
        ArrayList<Integer> copy = new ArrayList<>(arr);
        int min = Math.min(posList.size(), negList.size());
        int j = 0;
        for(int i = 0; i < min*2; i++) {
            if(i % 2 == 0) {
                arr.set(i, posList.get(j++));
            }
        }
    }
}
