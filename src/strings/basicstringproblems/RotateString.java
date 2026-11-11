package strings.basicstringproblems;

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String temp = s;
        for(int i = 0; i < s.length(); i++) {
            String tempString = "";
            char firstChar = s.charAt(i);
            for(int j = 1; j < temp.length(); j++) {
                tempString = tempString + temp.charAt(j);
            }
            tempString += firstChar;
            if(tempString.equals(goal)) {
                return true;
            }
            temp = tempString;
        }
        return false;
    }
}