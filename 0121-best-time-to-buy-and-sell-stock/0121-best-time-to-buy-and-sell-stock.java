class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minValue = prices[0];
        int maxProfit = 0;
        for (int i=1; i<n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return maxProfit;
    }
}