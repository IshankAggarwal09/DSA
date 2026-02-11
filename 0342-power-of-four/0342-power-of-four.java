class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n-1)) == 0);
    }
    public boolean isSquare(int n) {
        int root = (int)(Math.sqrt(n));
        return (root * root == n);
    }
    public boolean isPowerOfFour(int n) {
        return isPowerOfTwo(n) && isSquare(n);
    }
}