class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        for (int i=0; i<n; i++) {
            freeServers.add(new int[] { servers[i], i });
        }
        int currentTime = 0;
        for (int j=0; j<m; j++) {
            currentTime = Math.max(currentTime, j);
            if (freeServers.isEmpty()) {
                currentTime = Math.max(currentTime, busyServers.peek()[0]);
            }
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                int[] server = busyServers.poll();
                freeServers.add(new int[] { server[1], server[2] });
            }
            int[] chosenServer = freeServers.poll();
            int weight = chosenServer[0];
            int index = chosenServer[1];
            ans[j] = index;
            busyServers.add(new int[] { currentTime + tasks[j], weight, index });
        }
        return ans;
    }
}