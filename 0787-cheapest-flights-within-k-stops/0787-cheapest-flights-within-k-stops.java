class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] a : flights) {
            map.get(a[0]).add(new int[]{a[1], a[2]});
        }
        pq.add(new int[] {src, 0, -1});
        int[][] cost = new int[n][k + 2];
        for (int[] a : cost) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        cost[src][0] = 0;
        while (!pq.isEmpty()) {
            int[] b = pq.poll();
            int st = b[0];
            int dist = b[1];
            int stop = b[2];
            if (st == dst) {
                return dist;
            }
            if (stop >= k) {
                continue;
            }
            for (int[] c : map.get(st)) {
                int newDist = dist + c[1];
                int newStop = stop + 1;
                if (newDist < cost[c[0]][newStop + 1]) {
                    cost[c[0]][newStop + 1] = newDist;
                    pq.add(new int[]{c[0], newDist, newStop});
                }
            }
        }
        return -1;
    }
}