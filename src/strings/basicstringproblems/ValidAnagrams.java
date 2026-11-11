package strings.basicstringproblems;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        char [] charS = s.toCharArray();
        char [] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for(int i = 0; i < charS.length; i++) {
            if(charS[i] != charT[i]) {
                return false;
            }
        }
        return true;
    }
}
