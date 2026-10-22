class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for (int i=1; i<n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
            }
        }
        if (sorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        char mn = s.charAt(0), mx = s.charAt(0);
        for (int i=1; i<n; i++) {
            mn = (char) Math.min(mn, s.charAt(i));
            mx = (char) Math.max(mx, s.charAt(i));
        }
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        for (int i=0; i<n-1; i++) {
            if (s.charAt(i) == mn) {
                return 2;
            }
        }
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == mx) {
                return 2;
            }
        }
        return 3;
    }
}