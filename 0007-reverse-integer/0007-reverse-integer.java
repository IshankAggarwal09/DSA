class Solution {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            int digit = x % 10;
            sum = sum * 10 + digit;
            x = x / 10;
        }
        if (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
            return (int) sum;
        }
        return 0;
    }
}