class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            if (i + k <= n) {
                set.add(s.substring(i, i+k));
            }
            if (set.size() == Math.pow(2, k)) {
                return true;
            }
        }
        return false;
    }
}