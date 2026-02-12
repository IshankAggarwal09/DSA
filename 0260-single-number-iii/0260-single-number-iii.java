class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int mask = (xor & (xor-1)) ^ xor;
        int b1 = 0;
        int b2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                b1 ^= num;
            }
            else {
                b2 ^= num;
            }
        }
        return new int[]{b1, b2};
    }
}