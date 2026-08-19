class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                while (left < right && s.charAt(left) == s.charAt(left+1)) {
                    left++;
                }
                while (left < right && s.charAt(right) == s.charAt(right-1)) {
                    right--;
                }
                left++;
                right--;
            }
            else {
                break;
            }
        }
        if (left <= right) {
            return right - left + 1;
        }
        return 0;
    }
}