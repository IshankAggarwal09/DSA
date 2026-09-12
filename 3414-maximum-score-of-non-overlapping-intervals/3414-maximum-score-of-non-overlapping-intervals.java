class Solution {
    static class State {
        long score;
        int[] indices;
        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i=0; i<n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[3], b[3]);
        });
        int[] previous = new int[n];
        for (int i=0; i<n; i++) {
            int low = 0;
            int high = i - 1;
            int answer = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid][1] < arr[i][0]) {
                    answer = mid;
                    low = mid + 1;
                } 
                else {
                    high = mid - 1;
                }
            }
            previous[i] = answer;
        }
        State[][] dp = new State[n + 1][5];
        for (int i=0; i<=n; i++) {
            dp[i][0] = new State(0, new int[0]);
        }
        for (int i=1; i<=n; i++) {
            int current = i - 1;
            for (int k=1; k<=4; k++) {
                State best = dp[i - 1][k];
                int prev = previous[current];
                State before = dp[prev + 1][k - 1];
                if (before != null) {
                    int[] indices = addIndex(
                        before.indices,
                        arr[current][3]
                    );
                    State take = new State(
                        before.score + arr[current][2],
                        indices
                    );
                    if (best == null || take.score > best.score || (take.score == best.score && isLexicographicallySmaller(take.indices, best.indices))) {
                        best = take;
                    }
                }
                dp[i][k] = best;
            }
        }
        State answer = dp[n][0];
        for (int k=1; k<=4; k++) {
            if (dp[n][k] != null && (dp[n][k].score > answer.score || (dp[n][k].score == answer.score && isLexicographicallySmaller(dp[n][k].indices, answer.indices)))) {
                answer = dp[n][k];
            }
        }
        return answer.indices;
    }
    private int[] addIndex(int[] indices, int index) {
        int[] result = Arrays.copyOf(indices, indices.length + 1);
        int i = result.length - 1;
        while (i > 0 && result[i - 1] > index) {
            result[i] = result[i - 1];
            i--;
        }
        result[i] = index;
        return result;
    }
    private boolean isLexicographicallySmaller(int[] a, int[] b) {
        for (int i=0; i<Math.min(a.length, b.length); i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return a.length < b.length;
    }
}