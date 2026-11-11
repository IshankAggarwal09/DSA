class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        return cost1 + cost2 < costBoth ? 1L * cost1 * need1 + 1L * cost2 * need2 : 1L * costBoth * Math.min(need1, need2) + 1L * (need1 - Math.min(need1, need2)) * Math.min(cost1, costBoth) + 1L * (need2 - Math.min(need1, need2)) * Math.min(cost2, costBoth);
    }
}