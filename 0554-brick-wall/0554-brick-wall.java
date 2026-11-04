class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> map = new HashMap<>();
        int maximum = 0;
        for (List<Integer> row : wall) {
            long brickEnd = 0;
            for (int i=0; i<row.size()-1; i++) {
                brickEnd += row.get(i);
                map.put(brickEnd, map.getOrDefault(brickEnd, 0) + 1);
                maximum = Math.max(maximum, map.get(brickEnd));
            }
        }
        return wall.size() - maximum;
    }
}