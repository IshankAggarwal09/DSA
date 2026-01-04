class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int start = 1;
        int end = x/2;
        int ans = 0;
        while (start <= end) {
            long mid = start + (end - start)/2;
            if (mid*mid <= x) {
                ans = (int)mid;
                start = (int)mid + 1;
            }
            else {
                end = (int)mid - 1;
            }
        }
        return ans;
    }
}