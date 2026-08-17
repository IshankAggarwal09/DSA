class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int last = -1;
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                last = i;
                ans[i] = 0;
            }
            else if (last != -1) {
                ans[i] = i - last;
            }
        }
        int next = -1;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == c) {
                next = i;
                ans[i] = 0;
            }
            else if (next != -1) {
                ans[i] = Math.min(ans[i], next - i);
            }
        }
        return ans;
    }
}