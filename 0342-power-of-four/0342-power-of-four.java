class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n-1)) == 0);
    }
    public boolean isDivByThree(int n) {
        return (n-1) % 3 == 0;
    }
    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n) && isDivByThree(n);
    }
}