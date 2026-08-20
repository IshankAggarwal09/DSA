class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        int n1 = start.length();
        int n2 = target.length();
        while (i < n1 || j < n2) {
            while (i < n1 && start.charAt(i) == '_') {
                i++;
            }
            while (j < n2 && target.charAt(j) == '_') {
                j++;
            }
            if (i == n1 && j == n2) {
                return true;
            }
            if (i == n1 || j == n2) {
                return false;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}