class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int start = 1;
        int end = max;
        while (start < end) {
            int mid = start + (end-start)/2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours > h) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}