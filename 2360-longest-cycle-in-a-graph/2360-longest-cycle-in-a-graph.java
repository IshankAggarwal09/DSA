class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        int answer = -1;
        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            int current = i;
            int step = 0;
            HashMap<Integer, Integer> path = new HashMap<>();
            while (current != -1 && !visited[current]) {
                visited[current] = true;
                path.put(current, step);
                distance[current] = step;
                step++;
                current = edges[current];
            }
            if (current != -1 && path.containsKey(current)) {
                int cycleLength = step - path.get(current);
                answer = Math.max(answer, cycleLength);
            }
        }
        return answer;
    }
}