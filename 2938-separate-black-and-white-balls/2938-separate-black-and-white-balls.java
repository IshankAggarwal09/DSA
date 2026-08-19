class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        int left = s.length() - 1;
        int right = s.length() - 1;
        while (left >= 0) {
            if (s.charAt(left) == '1') {
                ans += Math.abs(left - right);
                left--;
                right--;
            }
            while (left >= 0 && s.charAt(left) != '1') {
                left--;
            }
        }
        return ans;
    }
}