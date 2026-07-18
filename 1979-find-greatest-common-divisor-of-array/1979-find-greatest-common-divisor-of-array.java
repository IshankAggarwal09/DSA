class Solution {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }
        return gcd(smallest, largest);
    }
}