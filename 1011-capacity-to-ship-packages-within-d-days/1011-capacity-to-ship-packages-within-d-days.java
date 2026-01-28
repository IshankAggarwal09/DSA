class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = -1;
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int start = maxWeight;
        int end = totalWeight;
        while (start < end) {
            int mid = start + (end-start)/2;
            int daysNeeded = 1;
            int currWeight = 0;
            for (int weight : weights) {
                if (currWeight + weight > mid) {
                    daysNeeded++;
                    currWeight = 0;
                }
                currWeight += weight;
            }
            if (daysNeeded > days) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}