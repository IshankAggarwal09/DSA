class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int numQuery = queries.length;
        int[][] queriesWithIndex = new int[numQuery][2];
        for(int i=0; i<numQuery; i++){
            queriesWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        Arrays.sort(queriesWithIndex, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (a, b) -> ((a[1] - a[0]) - (b[1] - b[0]))
        );
        int[] result = new int[numQuery];
        int j = 0;
        for(int i=0; i<queries.length; i++){
            int queryVal = queriesWithIndex[i][0];
            int queryIndex = queriesWithIndex[i][1];
            while(j < intervals.length && intervals[j][0] <= queryVal){
                minHeap.add(intervals[j]);
                j++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal){
                minHeap.remove();
            }
            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1); 
        }
        return result;
    }
}