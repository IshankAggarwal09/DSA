class Solution {
    public int checkSwaps(char[] c, char symbol) {
        int swaps = 0;
        for (int i=0; i<c.length; i++) {
            if (c[i] == symbol && i % 2 != 0) {
                swaps++;
            }
        }
        return swaps;
    }
    public int minSwaps(String s) {
        int ones = 0;
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
            else {
                zeros++;
            }
        }
        if (Math.abs(ones - zeros) > 1) {
            return -1;
        }
        if (ones > zeros) {
            return checkSwaps(s.toCharArray(), '1');
        }
        else if (zeros > ones) {
            return checkSwaps(s.toCharArray(), '0');
        }
        else {
            return Math.min(checkSwaps(s.toCharArray(), '1'), checkSwaps(s.toCharArray(), '0'));
        }
    }
}