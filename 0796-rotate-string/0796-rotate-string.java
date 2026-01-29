class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubledStr = s + s;
        return doubledStr.contains(goal);
    }
}