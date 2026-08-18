class Solution {
    public int countBinarySubstrings(String s) {
        int previousGroup = 0;
        int currentGroup = 1;
        int ans = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                currentGroup++;
            }
            else {
                ans += Math.min(previousGroup, currentGroup);
                previousGroup = currentGroup;
                currentGroup = 1;
            }
        }
        ans += Math.min(previousGroup, currentGroup);
        return ans;
    }
}