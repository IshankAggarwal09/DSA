class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        int i = 0;
        while (left < chars.length) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            chars[i++] = chars[left];
            if (right - left > 1) {
                String s = String.valueOf(right - left);
                for (int j=0; j<s.length(); j++) {
                    chars[i++] = s.charAt(j);
                }
            }
            left = right;
        }
        return i;
    }
}