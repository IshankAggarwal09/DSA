class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        int ans = 0;
        boolean sign  = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = false;
        }
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long quotient = 0;
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            quotient += 1L << count;
            n -= (d << count);
        }
        if (quotient == (1L << 31) && sign) {
            return Integer.MAX_VALUE;
        }
        if (quotient == (1L << 31) && !sign) {
            return Integer.MIN_VALUE;
        }
        return sign ? (int)quotient : (int)(-1 * quotient);
    }
}