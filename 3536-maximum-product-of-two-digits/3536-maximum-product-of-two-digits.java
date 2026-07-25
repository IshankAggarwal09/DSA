class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while (n != 0) {
            int d = n % 10;
            max2 = Math.max(max2, Math.min(max1, d));
            max1 = Math.max(max1, d);
            n /= 10;
        }
        return max1 * max2;
    }
}